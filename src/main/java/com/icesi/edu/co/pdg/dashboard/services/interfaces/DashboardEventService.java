package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.EventDashboardDTO;

public interface DashboardEventService {
	
	public List<EventDashboardDTO> getAllEvents() throws Exception;

}
