package com.icesi.edu.co.pdg.dashboard.services.interfaces;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.ActionHistoryListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;

public interface ActionHistoryService {
	
	public ActionHistoryDTO addActionHistory(ActionHistoryInDTO actionHistory, Integer alarmid) throws Exception;
	public List<ActionHistoryDTO> getAllActionsHistoryByAlarmId(Integer alarmid) throws Exception;

}
