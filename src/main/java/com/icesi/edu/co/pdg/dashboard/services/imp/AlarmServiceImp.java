package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.StateAlarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.AlarmMapper;
import com.icesi.edu.co.pdg.dashboard.model.mappers.TypeAlarmMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.AlarmRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.StateAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AlarmService;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.EmailService;

@Service
public class AlarmServiceImp implements AlarmService {
	
	@Autowired
	private AlarmRepository alarmRepository;
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
	public void addAlarms(List<AlarmDTO> alarmsDTO) throws Exception {
		StateAlarm stateAlarm=stateAlarmRepository.findByStateAlarmNameContaining("Activa");
		if(stateAlarm==null) {
			throw new NoResultException();
		}else {
			for (AlarmDTO alarmDTO : alarmsDTO) {
				alarmDTO.setStateAlarm(stateAlarm);
	        }
			List<Alarm> alarms = AlarmMapper.INSTANCE.alarmDTOToalarm(alarmsDTO);
			for (Alarm alarm : alarms) {
				alarmRepository.save(alarm);
				alarmsToSend.add(alarm);
				if(checkMaxAlarmsReached(alarm.getTypeAlarm())) {
					System.out.println("CORREO ENVIADO");
					List<String> email = new ArrayList<>();
					email.add("carolinapasuy@hotmail.com");
					emailService.sendEmail(email, alarmsDTO.get(0).getTypeAlarm(),alarmsToSend);
					alarmsToSend.clear();
				}
	        }
		}
	}

	@Override
	public List<AlarmListOutDTO> getAllAlarms() throws Exception {
		List<Alarm> alarms = alarmRepository.findAll();
        if(alarms.isEmpty()) {
			throw new NoResultException();
        }else {
            List<AlarmListOutDTO> alarmsDTO = new ArrayList<AlarmListOutDTO>();
            for(Alarm alarm:alarms) {
            	AlarmListOutDTO alarmListDTO=AlarmMapper.INSTANCE.alarmToalarmListOutDTO(alarm,alarm.getTypeAlarm(),alarm.getTypeAlarm().getPlant(),alarm.getStateAlarm());
            	alarmListDTO.setUsersAssigned(alarm.getTypeAlarm().getEmailsAssignedUsers());
            	alarmsDTO.add(alarmListDTO);
            }
                       
            return alarmsDTO;
        }
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
		Optional<Alarm> alarm = alarmRepository.findById(alarmid);
        if(!alarm.isEmpty()){
			throw new NoResultException();
        }else {
            	AlarmDetailOutDTO alarmDTO=AlarmMapper.INSTANCE.alarmtoalarmDetailOutDTO(alarm.get(),alarm.get().getTypeAlarm(),alarm.get().getTypeAlarm().getPlant(),alarm.get().getStateAlarm());
            	alarmDTO.setUsersAssigned(alarm.get().getTypeAlarm().getEmailsAssignedUsers());
                       
            return alarmDTO;
        }
	}

}
