package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.out.DashboardEventOutDTO;

public interface DashboardEventService {
	
	public List<DashboardEventOutDTO> getAllEvents() throws Exception;

}
