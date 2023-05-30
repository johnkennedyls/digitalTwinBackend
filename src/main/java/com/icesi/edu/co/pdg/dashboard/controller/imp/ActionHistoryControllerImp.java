package com.icesi.edu.co.pdg.dashboard.controller.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.ActionHistoryController;
import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.ActionHistoryService;

@RestController
@RequestMapping("/actionHistory")
@CrossOrigin("Access-Control-Allow-Origin")
public class ActionHistoryControllerImp implements ActionHistoryController {
	
	@Autowired
	ActionHistoryService actionHistoryService;

	@Override
	@GetMapping("/{alarmid}")
	public ResponseEntity<List<ActionHistoryDTO>> getAllActionsHistoryByAlarm(@PathVariable("alarmid") Integer alarmid) throws Exception {
		List<ActionHistoryDTO> respOutDTO = new ArrayList<ActionHistoryDTO>();
		respOutDTO = actionHistoryService.getAllActionsHistoryByAlarmId(alarmid);
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}

	@Override
	@PostMapping("/create/{alarmid}")
	public ResponseEntity<ActionHistoryDTO> addActionHistory(@RequestBody ActionHistoryInDTO actionHistoryDTO,@PathVariable("alarmid") Integer alarmid) throws Exception {
		ActionHistoryDTO actionHistory;
		try {
			actionHistory = actionHistoryService.addActionHistory(actionHistoryDTO, alarmid);
			return new ResponseEntity<>(actionHistory, HttpStatus.CREATED);
		}catch(BadRequestDataException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
