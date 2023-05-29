package com.icesi.edu.co.pdg.dashboard.model.mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.EventDashboardDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-28T21:12:54-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230413-0857, environment: Java 17.0.7 (Eclipse Adoptium)"
)
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
