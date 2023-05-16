package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import org.springframework.http.ResponseEntity;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;

public interface ActionHistoryController {
	
	public ResponseEntity<?> getAllActionsHistoryByAlarm(Integer alarmid) throws Exception;
	public ResponseEntity<?> addActionHistory(ActionHistoryInDTO actionHistory, Integer alarmid) throws Exception;


}
