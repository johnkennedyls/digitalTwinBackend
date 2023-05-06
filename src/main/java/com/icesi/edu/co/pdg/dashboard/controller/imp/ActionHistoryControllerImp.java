package com.icesi.edu.co.pdg.dashboard.controller.imp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.ActionHistoryController;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;

@RestController
public class ActionHistoryControllerImp implements ActionHistoryController {

	@Override
	public ResponseEntity<?> getAllActionsHistory() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> addActionHistory(ActionHistoryInDTO actionHistory) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
