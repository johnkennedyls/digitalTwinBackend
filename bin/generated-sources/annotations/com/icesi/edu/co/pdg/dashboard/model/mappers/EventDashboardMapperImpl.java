package com.icesi.edu.co.pdg.dashboard.model.mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.EventDashboardDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T21:06:42-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
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
