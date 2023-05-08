package com.icesi.edu.co.pdg.dashboard.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;

@Mapper
public interface TypeAlarmMapper {
	
	TypeAlarmMapper INSTANCE = Mappers.getMapper(TypeAlarmMapper.class);
	
	TypeAlarmDTO typeAlarmToTypeAlarmDTO(TypeAlarm typeAlarm);
	
	TypeAlarm typeAlarmDTOtotypeAlarm(TypeAlarmDTO typeAlarmDTO);
	
	TypeAlarm addTypeAlarmDTOtotypeAlarm(TypeAlarmDTO typeAlarmDTO);
	
	List<TypeAlarmDTO> asListTypeAlarmDTO(List<TypeAlarm> typeAlarms);

}
