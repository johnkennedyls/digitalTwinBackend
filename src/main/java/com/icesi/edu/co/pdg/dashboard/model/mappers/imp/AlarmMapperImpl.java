package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.StateAlarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.AlarmMapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

public class AlarmMapperImpl implements AlarmMapper {

    @Override
    public Alarm alarmDTOtoalarm(AlarmDTO alarmDTO) {
        if ( alarmDTO == null ) {
            return null;
        }

        Alarm alarm = new Alarm();

        alarm.setActivationDate( alarmDTO.getActivationDate() );
        alarm.setStateAlarm( alarmDTO.getStateAlarm() );
        alarm.setTypeAlarm( alarmDTO.getTypeAlarm() );
        alarm.setTagValue( alarmDTO.getTagValue() );

        return alarm;
    }

    @Override
    public AlarmListOutDTO alarmToalarmListOutDTO(Alarm alarm, TypeAlarm typeAlarm, Plant plant, StateAlarm stateAlarm) {
        if ( alarm == null && typeAlarm == null && plant == null && stateAlarm == null ) {
            return null;
        }

        AlarmListOutDTO alarmListOutDTO = new AlarmListOutDTO();

        if ( alarm != null ) {
            alarmListOutDTO.setActivationDate( alarm.getActivationDate() );
            alarmListOutDTO.setAlarmId( alarm.getAlarmId() );
        }
        if ( typeAlarm != null ) {
            alarmListOutDTO.setTypeAlarmName( typeAlarm.getTypeAlarmName() );
            alarmListOutDTO.setCondition( typeAlarm.getCondition() );
        }
        if ( stateAlarm != null ) {
            alarmListOutDTO.setStateAlarmName( stateAlarm.getStateAlarmName() );
        }
        if ( plant != null ) {
            alarmListOutDTO.setPlantName(plant.getPlantName());;
        }

        return alarmListOutDTO;
    }

    @Override
    public List<Alarm> alarmDTOToalarm(List<AlarmDTO> alarmsDTO) {
        if ( alarmsDTO == null ) {
            return null;
        }

        List<Alarm> list = new ArrayList<Alarm>( alarmsDTO.size() );
        for ( AlarmDTO alarmDTO : alarmsDTO ) {
            list.add( alarmDTOtoalarm( alarmDTO ) );
        }

        return list;
    }

    @Override
    public AlarmDetailOutDTO alarmtoalarmDetailOutDTO(Alarm alarm, TypeAlarm typeAlarm, Plant plant, StateAlarm stateAlarm) {
        if ( alarm == null && typeAlarm == null && plant == null && stateAlarm == null ) {
            return null;
        }

        AlarmDetailOutDTO alarmDetailOutDTO = new AlarmDetailOutDTO();

        if ( alarm != null ) {
            alarmDetailOutDTO.setTagValue( alarm.getTagValue() );
            alarmDetailOutDTO.setActivationDate( alarm.getActivationDate() );
        }
        if ( typeAlarm != null ) {
            alarmDetailOutDTO.setTypeAlarmName( typeAlarm.getTypeAlarmName() );
            alarmDetailOutDTO.setCondition( typeAlarm.getCondition() );
        }
        if ( stateAlarm != null ) {
            alarmDetailOutDTO.setStateAlarmName( stateAlarm.getStateAlarmName() );
        }

        return alarmDetailOutDTO;
    }
}
