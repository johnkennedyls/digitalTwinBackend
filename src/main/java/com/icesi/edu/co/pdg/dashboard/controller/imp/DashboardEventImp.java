package com.icesi.edu.co.pdg.dashboard.controller.imp;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.DashboardEventController;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.EventDashboardDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.DashboardEventService;

@RestController
@RequestMapping("/events")
@CrossOrigin("Access-Control-Allow-Origin")
public class DashboardEventImp implements DashboardEventController {
	
	@Autowired
	DashboardEventService dashboardEventService;
	
	@Override
	@GetMapping("/")
	public ResponseEntity<List<EventDashboardDTO>> getAllEvents() throws Exception {
		List<EventDashboardDTO> respOutDTO = new ArrayList<EventDashboardDTO>();
		respOutDTO = dashboardEventService.getAllEvents();
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}

}
