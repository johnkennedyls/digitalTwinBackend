package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.StateAlarmInDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.StateAlarm;
import com.icesi.edu.co.pdg.dashboard.repositories.AlarmRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.StateAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.StateAlarmService;

@Service
public class StateAlarmServiceImp implements StateAlarmService{
	
	@Autowired
	AlarmRepository alarmRepository;
	@Autowired
	StateAlarmRepository stateAlarmRepository;

	
	@Override
	public StateAlarmInDTO changeStateAlarm(StateAlarmInDTO stateAlarmInDTO,Integer alarmid) throws Exception {
		if(alarmid<0 || alarmid==null) {
			throw new BadRequestDataException();
		}else {
			Optional<Alarm> alarm=alarmRepository.findById(alarmid);
			if(alarm.isEmpty()) {
				throw new NoResultException();
			}else {
				StateAlarm stateAlarmFounded=stateAlarmRepository.findByStateAlarmNameContaining(stateAlarmInDTO.getStateAlarmName());
				if(stateAlarmFounded==null) {
					throw new NoResultException();
				}else {
					if(alarm.get().getStateAlarm().getStateAlarm()==stateAlarmFounded) {
						if(stateAlarmFounded.getStateAlarmName().equalsIgnoreCase("Cerrado")) {
							List<Alarm> alarms=alarmRepository.findByTypeAlarmTypeAlarmId(alarm.get().getTypeAlarm().getTypeAlarmId());
							for(Alarm alarmSate:alarms) {
								alarmSate.setStateAlarm(stateAlarmFounded);
								alarmRepository.save(alarmSate);
							}
						}else {
							alarm.get().setStateAlarm(stateAlarmFounded);
							alarmRepository.save(alarm.get());
						}
					}
				}
			}
		}
		return stateAlarmInDTO;
	}

}
