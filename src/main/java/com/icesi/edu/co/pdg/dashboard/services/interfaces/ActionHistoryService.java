package com.icesi.edu.co.pdg.dashboard.services.interfaces;
import java.util.List;


import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;

public interface ActionHistoryService {
	
	public ActionHistoryDTO addActionHistory(ActionHistoryInDTO actionHistory, Integer alarmid) throws Exception;
	public List<ActionHistoryDTO> getAllActionsHistoryByAlarmId(Integer alarmid) throws Exception;

}
