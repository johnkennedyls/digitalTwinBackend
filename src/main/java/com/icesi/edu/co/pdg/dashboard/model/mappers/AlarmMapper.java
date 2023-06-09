package com.icesi.edu.co.pdg.dashboard.model.mappers;

import java.util.List;


import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.StateAlarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.imp.AlarmMapperImpl;

public interface AlarmMapper {
	
	AlarmMapper INSTANCE = new AlarmMapperImpl();
	
	Alarm alarmDTOtoalarm(AlarmDTO alarmDTO);
	AlarmListOutDTO alarmToalarmListOutDTO(Alarm alarm,TypeAlarm typeAlarm,Plant plant,StateAlarm stateAlarm);
	List<Alarm> alarmDTOToalarm(List<AlarmDTO> alarmsDTO);
	AlarmDetailOutDTO alarmtoalarmDetailOutDTO(Alarm alarm,TypeAlarm typeAlarm,Plant plant,StateAlarm stateAlarm);
}
