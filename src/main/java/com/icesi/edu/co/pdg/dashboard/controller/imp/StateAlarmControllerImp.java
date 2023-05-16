package com.icesi.edu.co.pdg.dashboard.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.StateAlarmController;
import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.StateAlarmInDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.StateAlarmService;

@RestController
@CrossOrigin("*")
@RequestMapping("/statesAlarm")
public class StateAlarmControllerImp implements StateAlarmController{

	@Autowired
	StateAlarmService stateAlarmService;
	
	@Override
	@PostMapping("/change/{alarmid}")
	public ResponseEntity<StateAlarmInDTO>changeStateAlarm(@RequestBody StateAlarmInDTO stateAlarmInDTO,@PathVariable("alarmid")Integer alarmid) throws Exception {
		StateAlarmInDTO state;
		try {
			state=stateAlarmService.changeStateAlarm(stateAlarmInDTO, alarmid);
			return new ResponseEntity<>(state, HttpStatus.OK);
		}catch(BadRequestDataException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
