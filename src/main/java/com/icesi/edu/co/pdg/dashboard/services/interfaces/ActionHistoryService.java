package com.icesi.edu.co.pdg.dashboard.services.interfaces;
import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.ActionHistoryListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;

public interface ActionHistoryService {
	
	public List<ActionHistoryListOutDTO> getAllActionsHistory() throws Exception;
	public ActionHistory addActionHistory(ActionHistoryInDTO actionHistory) throws Exception;

}
