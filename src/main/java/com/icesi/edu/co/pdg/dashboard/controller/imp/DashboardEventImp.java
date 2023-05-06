package com.icesi.edu.co.pdg.dashboard.controller.imp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.DashboardEventController;

@RestController
public class DashboardEventImp implements DashboardEventController {

	@Override
	public ResponseEntity<?> getAllEvents() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
