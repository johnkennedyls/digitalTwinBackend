package com.icesi.edu.co.pdg.dashboard.model.mappers;

import java.util.List;


import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.imp.TypeAlarmMapperImpl;


public interface TypeAlarmMapper {
	
	TypeAlarmMapper INSTANCE = new TypeAlarmMapperImpl();
	
	TypeAlarmDTO typeAlarmToTypeAlarmDTO(TypeAlarm typeAlarm);
	
	TypeAlarm typeAlarmDTOtotypeAlarm(TypeAlarmDTO typeAlarmDTO);
	
	TypeAlarm addTypeAlarmDTOtotypeAlarm(TypeAlarmDTO typeAlarmDTO);
	
	List<TypeAlarmDTO> asListTypeAlarmDTO(List<TypeAlarm> typeAlarms);
	
	TypeAlarmListOutDTO typeAlarmToAlarmListOutDTO(TypeAlarm typeAlarm,Plant plant);
	
	TypeAlarmDetailOutDTO typeAlarmToTypeAlarmDetailOutDTO(Integer id,TypeAlarm typeAlarm,Plant plant,EventDashboard event);

}
