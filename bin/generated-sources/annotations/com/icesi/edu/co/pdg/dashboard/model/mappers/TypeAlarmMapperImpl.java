package com.icesi.edu.co.pdg.dashboard.model.mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-28T21:13:02-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
public class TypeAlarmMapperImpl implements TypeAlarmMapper {

    @Override
    public TypeAlarmDTO typeAlarmToTypeAlarmDTO(TypeAlarm typeAlarm) {
        if ( typeAlarm == null ) {
            return null;
        }

        TypeAlarmDTO typeAlarmDTO = new TypeAlarmDTO();

        typeAlarmDTO.setTypeAlarmName( typeAlarm.getTypeAlarmName() );
        typeAlarmDTO.setTypeAlarmDescription( typeAlarm.getTypeAlarmDescription() );
        typeAlarmDTO.setCondition( typeAlarm.getCondition() );
        typeAlarmDTO.setNumberAlarmsMax( typeAlarm.getNumberAlarmsMax() );

        return typeAlarmDTO;
    }

    @Override
    public TypeAlarm typeAlarmDTOtotypeAlarm(TypeAlarmDTO typeAlarmDTO) {
        if ( typeAlarmDTO == null ) {
            return null;
        }

        TypeAlarm typeAlarm = new TypeAlarm();

        typeAlarm.setCondition( typeAlarmDTO.getCondition() );
        typeAlarm.setTypeAlarmDescription( typeAlarmDTO.getTypeAlarmDescription() );
        typeAlarm.setTypeAlarmName( typeAlarmDTO.getTypeAlarmName() );
        typeAlarm.setNumberAlarmsMax( typeAlarmDTO.getNumberAlarmsMax() );

        return typeAlarm;
    }

    @Override
    public TypeAlarm addTypeAlarmDTOtotypeAlarm(TypeAlarmDTO typeAlarmDTO) {
        if ( typeAlarmDTO == null ) {
            return null;
        }

        TypeAlarm typeAlarm = new TypeAlarm();

        typeAlarm.setCondition( typeAlarmDTO.getCondition() );
        typeAlarm.setTypeAlarmDescription( typeAlarmDTO.getTypeAlarmDescription() );
        typeAlarm.setTypeAlarmName( typeAlarmDTO.getTypeAlarmName() );
        typeAlarm.setNumberAlarmsMax( typeAlarmDTO.getNumberAlarmsMax() );

        return typeAlarm;
    }

    @Override
    public List<TypeAlarmDTO> asListTypeAlarmDTO(List<TypeAlarm> typeAlarms) {
        if ( typeAlarms == null ) {
            return null;
        }

        List<TypeAlarmDTO> list = new ArrayList<TypeAlarmDTO>( typeAlarms.size() );
        for ( TypeAlarm typeAlarm : typeAlarms ) {
            list.add( typeAlarmToTypeAlarmDTO( typeAlarm ) );
        }

        return list;
    }

    @Override
    public TypeAlarmListOutDTO typeAlarmToAlarmListOutDTO(TypeAlarm typeAlarm, Plant plant) {
        if ( typeAlarm == null && plant == null ) {
            return null;
        }

        TypeAlarmListOutDTO typeAlarmListOutDTO = new TypeAlarmListOutDTO();

        if ( typeAlarm != null ) {
            typeAlarmListOutDTO.setTypeAlarmId( typeAlarm.getTypeAlarmId() );
            typeAlarmListOutDTO.setTypeAlarmName( typeAlarm.getTypeAlarmName() );
            typeAlarmListOutDTO.setTypeAlarmDescription( typeAlarm.getTypeAlarmDescription() );
            typeAlarmListOutDTO.setCondition( typeAlarm.getCondition() );
            typeAlarmListOutDTO.setNumberAlarmsMax( typeAlarm.getNumberAlarmsMax() );
        }
        if ( plant != null ) {
            typeAlarmListOutDTO.setPlantName( plant.getPlantName() );
        }

        return typeAlarmListOutDTO;
    }

    @Override
    public TypeAlarmDetailOutDTO typeAlarmToTypeAlarmDetailOutDTO(Integer id, TypeAlarm typeAlarm, Plant plant, EventDashboard event) {
        if ( id == null && typeAlarm == null && plant == null && event == null ) {
            return null;
        }

        TypeAlarmDetailOutDTO typeAlarmDetailOutDTO = new TypeAlarmDetailOutDTO();

        if ( id != null ) {
            typeAlarmDetailOutDTO.setId( id );
        }
        if ( typeAlarm != null ) {
            typeAlarmDetailOutDTO.setTypeAlarmName( typeAlarm.getTypeAlarmName() );
            typeAlarmDetailOutDTO.setTypeAlarmDescription( typeAlarm.getTypeAlarmDescription() );
            typeAlarmDetailOutDTO.setCondition( typeAlarm.getCondition() );
            typeAlarmDetailOutDTO.setNumberAlarmsMax( typeAlarm.getNumberAlarmsMax() );
        }
        if ( plant != null ) {
            typeAlarmDetailOutDTO.setPlantName( plant.getPlantName() );
        }
        if ( event != null ) {
            typeAlarmDetailOutDTO.setEventName( event.getEventName() );
        }

        return typeAlarmDetailOutDTO;
    }
}
