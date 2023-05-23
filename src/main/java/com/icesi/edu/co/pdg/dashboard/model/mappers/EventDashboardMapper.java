package com.icesi.edu.co.pdg.dashboard.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.EventDashboardDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;
@Mapper
public interface EventDashboardMapper {
	EventDashboardMapper INSTANCE = Mappers.getMapper(EventDashboardMapper.class);
	
	EventDashboardDTO eventDashboardToEventDashboardDTO(EventDashboard eventDashboard);

}
