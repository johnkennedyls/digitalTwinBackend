package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces.TypeAlarmMapper;

import co.edu.icesi.dev.saamfi.dtos.speout.InstitutionSpecOutDTO;

public class TypeAlarmMapperImp implements TypeAlarmMapper{

	@Override
	public TypeAlarmOutDTO typeAlarmToTypeAlarmOutDTO(TypeAlarm typeAlarm) {
		if ( typeAlarm == null ) {
			return null;
		}
		TypeAlarmOutDTO typeAlarmOutDTO = new TypeAlarmOutDTO();

		typeAlarmOutDTO.setTypeAlarmName(typeAlarm.getTypeAlarmName());;
		typeAlarmOutDTO.setTypeAlarmDescription(typeAlarm.getTypeAlarmDescription());
		typeAlarmOutDTO.setTagName(typeAlarm.getValue().getTagName());
		typeAlarmOutDTO.setCondition(typeAlarm.getCondition());
		return typeAlarmOutDTO;
	}

}
