package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import org.springframework.http.ResponseEntity;

public interface AlarmController {
	
	public ResponseEntity<?> getAllAlarmsGenerate() throws Exception;

}
