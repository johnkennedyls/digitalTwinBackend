package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import org.springframework.http.ResponseEntity;

public interface DashboardEventController {
	
	public ResponseEntity<?> getAllEvents() throws Exception;

}
