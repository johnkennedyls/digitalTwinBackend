package com.icesi.edu.co.pdg.dashboard.services.interfaces;


import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;

public interface TypeAlarmService {
	
	public TypeAlarmDTO addTypeAlarm(TypeAlarmDTO typeAlarm) throws Exception;

	public TypeAlarmDTO editTypeAlarm(Integer typeAlarmid, TypeAlarmDTO typeAlarm) throws Exception;

	public TypeAlarm deleteTypeAlarm(Integer typeAlarmid) throws Exception;
	
	public TypeAlarmDTO getTypeAlarm(Integer typeAlarmid) throws Exception;

	public List<TypeAlarmDTO> getAllTypeAlarms () throws Exception;
}
