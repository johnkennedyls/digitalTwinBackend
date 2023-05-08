package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;


public interface TypeAlarmController {
	
	public ResponseEntity<TypeAlarmDTO> getTypeAlarm(Integer typealarmid) throws Exception;
	public ResponseEntity<List<TypeAlarmDTO>> getAllTypeAlarms() throws Exception;
	public ResponseEntity<TypeAlarmDTO> addTypeAlarm(TypeAlarmDTO typealarm) throws Exception;
	public ResponseEntity<TypeAlarmDTO> editTypeAlarm(Integer typealarmid, TypeAlarmDTO typealarm) throws Exception;
	public ResponseEntity<String> deleteTypeAlarm(Integer typealarmid) throws Exception;


}
