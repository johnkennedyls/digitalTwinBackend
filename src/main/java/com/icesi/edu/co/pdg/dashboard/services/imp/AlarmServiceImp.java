package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.StateAlarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.ActionHistoryMapper;
import com.icesi.edu.co.pdg.dashboard.model.mappers.AlarmMapper;
import com.icesi.edu.co.pdg.dashboard.model.mappers.TypeAlarmMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.AlarmRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.StateAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.TypeAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AlarmService;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.EmailService;

@Service
@Transactional
public class AlarmServiceImp implements AlarmService {
	
	@Autowired
	private AlarmRepository alarmRepository;
	@Autowired
	private TypeAlarmRepository typeAlarmRepository;
	@Autowired
	private StateAlarmRepository stateAlarmRepository;
	@Autowired
	private EmailService emailService;
	
	private List<Alarm> alarmsToSend;
	
	@Autowired
	public AlarmServiceImp() {
		this.alarmsToSend = new ArrayList<>();
	}

	@Override
	public void addAlarm(AlarmDTO alarmDTO) throws Exception {
		StateAlarm stateAlarm=stateAlarmRepository.findByStateAlarmNameContaining("Activa");
		if(stateAlarm==null) {
			throw new NoResultException();
		}else {
			alarmDTO.setStateAlarm(stateAlarm);
			Alarm alarm = AlarmMapper.INSTANCE.alarmDTOtoalarm(alarmDTO);
			alarmRepository.save(alarm);
			alarmsToSend.add(alarm);
			if(checkMaxAlarmsReached(alarm.getTypeAlarm())) {
				emailService.sendEmail(alarm.getTypeAlarm().getEmailsAssignedUsers(), alarmDTO.getTypeAlarm(),alarmsToSend);
				alarmsToSend.clear();
	        }
		}
	}

	@Override
	public List<AlarmListOutDTO> getAllAlarms() throws Exception {
		List<Alarm> alarms = alarmRepository.findAll();
            List<AlarmListOutDTO> alarmsDTO = new ArrayList<AlarmListOutDTO>();
            for(Alarm alarm:alarms) {
            	AlarmListOutDTO alarmListDTO=AlarmMapper.INSTANCE.alarmToalarmListOutDTO(alarm,alarm.getTypeAlarm(),alarm.getTypeAlarm().getPlant(),alarm.getStateAlarm());
            	alarmListDTO.setUsersAssigned(alarm.getTypeAlarm().getEmailsAssignedUsers());
            	alarmsDTO.add(alarmListDTO);
            }
                       
            return alarmsDTO;
	}
	@Override
	public Boolean checkMaxAlarmsReached(TypeAlarm typeAlarm) {
	    if (this.alarmsToSend.size() >= typeAlarm.getNumberAlarmsMax()) {
	        return true;
	    }else {
	    	return false;
	    }
	}

	@Override
	public AlarmDetailOutDTO getAlarm(Integer alarmid) throws Exception {
		if(alarmid<0 || alarmid==null) {
			throw new BadRequestDataException();
		}else {
			Optional<Alarm> alarm = alarmRepository.findById(alarmid);
	        if(alarm.isEmpty()){
				throw new NoResultException();
	        }else {
	        		List<ActionHistoryDTO> actionHistoriesDTO=new ArrayList<ActionHistoryDTO>();
	            	AlarmDetailOutDTO alarmDTO=AlarmMapper.INSTANCE.alarmtoalarmDetailOutDTO(alarm.get(),alarm.get().getTypeAlarm(),alarm.get().getTypeAlarm().getPlant(),alarm.get().getStateAlarm());
	            	for(ActionHistory actionHistory: alarm.get().getActionHistories()) {
	            		ActionHistoryDTO actionHistoryDTO=ActionHistoryMapper.INSTANCE.actionHistorytoActionHistoryDTO(actionHistory);
	            		actionHistoriesDTO.add(actionHistoryDTO);
	            	}
	            	alarmDTO.setUsersAssigned(alarm.get().getTypeAlarm().getEmailsAssignedUsers());   
	            	alarmDTO.setActionsHistory(actionHistoriesDTO);
	            return alarmDTO;
	        }
		}
	}
	@Override
	public List<AlarmListOutDTO> getAllAlarmsClosed() throws Exception {
		List<Alarm> alarms = alarmRepository.findClosedAlarms();
            List<AlarmListOutDTO> alarmsDTO = new ArrayList<AlarmListOutDTO>();
            for(Alarm alarm:alarms) {
            	AlarmListOutDTO alarmListDTO=AlarmMapper.INSTANCE.alarmToalarmListOutDTO(alarm,alarm.getTypeAlarm(),alarm.getTypeAlarm().getPlant(),alarm.getStateAlarm());
            	alarmListDTO.setUsersAssigned(alarm.getTypeAlarm().getEmailsAssignedUsers());
            	alarmsDTO.add(alarmListDTO);
            }
                       
            return alarmsDTO;
	}
	
	@Override
	public List<AlarmListOutDTO> getAllAlarmsActive() throws Exception {
		List<Alarm> alarms = alarmRepository.findActiveOrUnderReviewAlarms();
            List<AlarmListOutDTO> alarmsDTO = new ArrayList<AlarmListOutDTO>();
            for(Alarm alarm:alarms) {
            	AlarmListOutDTO alarmListDTO=AlarmMapper.INSTANCE.alarmToalarmListOutDTO(alarm,alarm.getTypeAlarm(),alarm.getTypeAlarm().getPlant(),alarm.getStateAlarm());
            	alarmListDTO.setUsersAssigned(alarm.getTypeAlarm().getEmailsAssignedUsers());
            	alarmsDTO.add(alarmListDTO);
            }
                       
            return alarmsDTO;
	}
	@Override
	public List<AlarmListOutDTO> getAllAlarmsClosedByPlantId(Integer plantid) throws Exception {
		List<Alarm> alarms = alarmRepository.findClosedAlarmsAndPlantid(plantid);
            List<AlarmListOutDTO> alarmsDTO = new ArrayList<AlarmListOutDTO>();
            for(Alarm alarm:alarms) {
            	AlarmListOutDTO alarmListDTO=AlarmMapper.INSTANCE.alarmToalarmListOutDTO(alarm,alarm.getTypeAlarm(),alarm.getTypeAlarm().getPlant(),alarm.getStateAlarm());
            	alarmListDTO.setUsersAssigned(alarm.getTypeAlarm().getEmailsAssignedUsers());
            	alarmsDTO.add(alarmListDTO);
            }
                       
            return alarmsDTO;
	}
	@Override
	public List<AlarmListOutDTO> getAllAlarmsActiveByPlantId(Integer plantid) throws Exception {
		List<Alarm> alarms = alarmRepository.findActiveOrUnderReviewAlarmsAndPlantid(plantid);
            List<AlarmListOutDTO> alarmsDTO = new ArrayList<AlarmListOutDTO>();
            for(Alarm alarm:alarms) {
            	AlarmListOutDTO alarmListDTO=AlarmMapper.INSTANCE.alarmToalarmListOutDTO(alarm,alarm.getTypeAlarm(),alarm.getTypeAlarm().getPlant(),alarm.getStateAlarm());
            	alarmListDTO.setUsersAssigned(alarm.getTypeAlarm().getEmailsAssignedUsers());
            	alarmsDTO.add(alarmListDTO);
            }
                       
            return alarmsDTO;
	}
	
	@Override
	public void deleteByTypeAlarmTypeAlarmId(Integer typeAlarmid) throws Exception {
		if( typeAlarmid<0 || typeAlarmid==null) {
			throw new BadRequestDataException();
		}else {
			Optional<TypeAlarm> typeAlarm=typeAlarmRepository.findById(typeAlarmid);
			if(!typeAlarm.isEmpty()) {
				alarmRepository.deleteByTypeAlarmTypeAlarmId(typeAlarmid);
			}else {
				throw new NoResultException();
			}
		}
		
	}

}
