package com.icesi.edu.co.pdg.dashboard.services.interfaces;


import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;

public interface TypeAlarmService {
	
	public TypeAlarmDTO addTypeAlarm(TypeAlarmDTO typeAlarm) throws Exception;

	public TypeAlarmDTO editTypeAlarm(Integer typeAlarmid, TypeAlarmDTO typeAlarm) throws Exception;

	public TypeAlarm deleteTypeAlarm(Integer typeAlarmid) throws Exception;
	
	public TypeAlarmDetailOutDTO getTypeAlarm(Integer typeAlarmid) throws Exception;

	public List<TypeAlarmListOutDTO> getAllTypeAlarms () throws Exception;

	List<TypeAlarmListOutDTO> getAllTypeAlarmsByPlantid(Integer plantid) throws Exception;
}
