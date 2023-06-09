package com.icesi.edu.co.pdg.dashboard.model.mappers;


import com.icesi.edu.co.pdg.dashboard.model.dtos.EventDashboardDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;
import com.icesi.edu.co.pdg.dashboard.model.mappers.imp.EventDashboardMapperImpl;


public interface EventDashboardMapper {
	
	EventDashboardMapper INSTANCE = new EventDashboardMapperImpl();
	EventDashboardDTO eventDashboardToEventDashboardDTO(EventDashboard eventDashboard);

}
