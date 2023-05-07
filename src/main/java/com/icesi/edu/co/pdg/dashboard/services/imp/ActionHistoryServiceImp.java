package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.ActionHistoryListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.ActionHistoryService;

@Service
public class ActionHistoryServiceImp implements ActionHistoryService{


	@Override
	public ActionHistory addActionHistory(ActionHistoryInDTO actionHistory) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActionHistoryListOutDTO> getAllActionsHistory() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
