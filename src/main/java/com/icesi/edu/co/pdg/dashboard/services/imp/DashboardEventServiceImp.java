package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.icesi.edu.co.pdg.dashboard.model.dtos.EventDashboardDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.DashboardEvent;
import com.icesi.edu.co.pdg.dashboard.model.mappers.AlarmMapper;
import com.icesi.edu.co.pdg.dashboard.model.mappers.EventDashboardMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.DashboardEventRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.DashboardEventService;

@Service
public class DashboardEventServiceImp implements DashboardEventService {
	
	@Autowired
	DashboardEventRepository dashboardEventRepository;

	@Override
	@GetMapping("/")
	public List<EventDashboardDTO> getAllEvents() throws Exception {
		List<DashboardEvent> events = dashboardEventRepository.findAll();
        List<EventDashboardDTO>eventsDTO = new ArrayList<EventDashboardDTO>();
        for(DashboardEvent event:events) {
        	EventDashboardDTO eventDTO=EventDashboardMapper.INSTANCE.eventDashboardToEventDashboardDTO(event);
        	eventsDTO.add(eventDTO);
        }                  
        return eventsDTO;
	}

}
