package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.icesi.edu.co.pdg.dashboard.model.dtos.StateAlarmInDTO;

public interface StateAlarmController {
	

	ResponseEntity<StateAlarmInDTO> changeStateAlarm(StateAlarmInDTO stateAlarmInDTO, Integer alarmid) throws Exception;

}
