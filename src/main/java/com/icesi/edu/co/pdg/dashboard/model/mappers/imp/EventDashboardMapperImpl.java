package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import com.icesi.edu.co.pdg.dashboard.model.dtos.EventDashboardDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;
import com.icesi.edu.co.pdg.dashboard.model.mappers.EventDashboardMapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

public class EventDashboardMapperImpl implements EventDashboardMapper {

    @Override
    public EventDashboardDTO eventDashboardToEventDashboardDTO(EventDashboard eventDashboard) {
        if ( eventDashboard == null ) {
            return null;
        }

        EventDashboardDTO eventDashboardDTO = new EventDashboardDTO();

        eventDashboardDTO.setEventId( eventDashboard.getEventId() );
        eventDashboardDTO.setEventName( eventDashboard.getEventName() );

        return eventDashboardDTO;
    }
}
