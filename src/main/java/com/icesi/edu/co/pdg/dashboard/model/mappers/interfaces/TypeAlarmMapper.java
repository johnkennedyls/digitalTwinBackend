package com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;

@Mapper
public interface TypeAlarmMapper {
	
	TypeAlarmMapper INSTANCE = Mappers.getMapper(TypeAlarmMapper.class);
	
	TypeAlarmOutDTO typeAlarmToTypeAlarmOutDTO(TypeAlarm typeAlarm);

}
