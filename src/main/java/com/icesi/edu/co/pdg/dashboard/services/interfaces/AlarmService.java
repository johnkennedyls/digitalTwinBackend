package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;

public interface AlarmService {
	
	public List<AlarmListOutDTO> getAllAlarms () throws Exception;
	
	public void addAlarms(List<AlarmDTO> alarms) throws Exception;
	
	public AlarmDetailOutDTO getAlarm (Integer alarmid) throws Exception;
	
	Boolean checkMaxAlarmsReached(TypeAlarm typeAlarm);
	

}
