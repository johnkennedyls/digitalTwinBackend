package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;


public interface TypeAlarmController {
	
	public ResponseEntity<TypeAlarmDetailOutDTO> getTypeAlarm(Integer typealarmid) throws Exception;
	public ResponseEntity<List<TypeAlarmListOutDTO>> getAllTypeAlarms() throws Exception;
	public ResponseEntity<?> addTypeAlarm(TypeAlarmDTO typealarm) throws Exception;
	public ResponseEntity<TypeAlarmDTO> editTypeAlarm(Integer typealarmid, TypeAlarmDTO typealarm) throws Exception;
	public ResponseEntity<String> deleteTypeAlarm(Integer typealarmid) throws Exception;
	public ResponseEntity<List<TypeAlarmListOutDTO>> getAllTypeAlarmsByPlant(Integer typealarmid) throws Exception;


}
