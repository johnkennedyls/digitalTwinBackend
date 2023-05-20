package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;

public interface AlarmController {
	
	public ResponseEntity<List<AlarmListOutDTO>> getAllAlarmsGenerate() throws Exception;

	public ResponseEntity<AlarmDetailOutDTO> getAlarmById(Integer alarmid) throws Exception;

	public ResponseEntity<List<AlarmListOutDTO>> getAllAlarmsActive() throws Exception;

	public ResponseEntity<List<AlarmListOutDTO>> getAllAlarmsClosed() throws Exception;

}
