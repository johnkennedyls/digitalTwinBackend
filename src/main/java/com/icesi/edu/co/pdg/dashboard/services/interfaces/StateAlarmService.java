package com.icesi.edu.co.pdg.dashboard.services.interfaces;


import com.icesi.edu.co.pdg.dashboard.model.dtos.StateAlarmInDTO;

public interface StateAlarmService {
	StateAlarmInDTO changeStateAlarm(StateAlarmInDTO stateAlarmInDTO, Integer alarmid) throws Exception;
}
