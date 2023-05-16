package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icesi.edu.co.pdg.dashboard.model.dtos.StateAlarmInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.StateAlarmOutDTO;

public interface StateAlarmService {
	

	StateAlarmInDTO changeStateAlarm(StateAlarmInDTO stateAlarmInDTO, Integer alarmid) throws Exception;

}
