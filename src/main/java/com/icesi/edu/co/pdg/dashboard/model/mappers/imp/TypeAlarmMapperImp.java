package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import java.util.ArrayList;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces.TypeAlarmMapper;


public class TypeAlarmMapperImp implements TypeAlarmMapper{

	@Override
	public TypeAlarmDTO typeAlarmToTypeAlarmDTO(TypeAlarm typeAlarm) {
		if ( typeAlarm == null ) {
			return null;
		}
		TypeAlarmDTO typeAlarmOutDTO = new TypeAlarmDTO();

		typeAlarmOutDTO.setTypeAlarmName(typeAlarm.getTypeAlarmName());;
		typeAlarmOutDTO.setTypeAlarmDescription(typeAlarm.getTypeAlarmDescription());
		typeAlarmOutDTO.setTagName(typeAlarm.getTagName());
		typeAlarmOutDTO.setCondition(typeAlarm.getCondition());
		typeAlarmOutDTO.setUsersAssigned(typeAlarm.getAssignedUsers());
		
		return typeAlarmOutDTO;
	}

	@Override
	public TypeAlarm typeAlarmDTOtotypeAlarm(TypeAlarmDTO typeAlarmDTO) {
		if ( typeAlarmDTO == null ) {
			return null;
		}
		TypeAlarm typeAlarm = new TypeAlarm();
		
		typeAlarm.setTypeAlarmName(typeAlarmDTO.getTypeAlarmName());;
		typeAlarm.setTypeAlarmDescription(typeAlarmDTO.getTypeAlarmDescription());
		typeAlarm.setTagName(typeAlarmDTO.getTagName());
		typeAlarm.setCondition(typeAlarmDTO.getCondition());
		typeAlarm.setAssignedUsers(typeAlarmDTO.getUsersAssigned());
		
		
		return typeAlarm;
	}

	@Override
	public List<TypeAlarmDTO> asListTypeAlarmDTO(List<TypeAlarm> typeAlarms) {
		if ( typeAlarms == null ) {
            return null;
        }

        List<TypeAlarmDTO> list = new ArrayList<TypeAlarmDTO>( typeAlarms.size() );
        for ( TypeAlarm typeAlarm : typeAlarms ) {
            list.add( typeAlarmToTypeAlarmDTO( typeAlarm ) );
        }
        return list;
	}

	@Override
	public TypeAlarm addTypeAlarmDTOtotypeAlarm(TypeAlarmDTO typeAlarmDTO) {
		if ( typeAlarmDTO == null ) {
			return null;
		}
		TypeAlarm typeAlarm = new TypeAlarm();
		
		typeAlarm.setTypeAlarmName(typeAlarmDTO.getTypeAlarmName());;
		typeAlarm.setTypeAlarmDescription(typeAlarmDTO.getTypeAlarmDescription());
		typeAlarm.setTagName(typeAlarmDTO.getTagName());
		typeAlarm.setCondition(typeAlarmDTO.getCondition());
		
		
		return typeAlarm;
	}



}
