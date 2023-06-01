package com.icesi.edu.co.pdg.dashboard.model.mappers;


import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import com.icesi.edu.co.pdg.dashboard.model.mappers.imp.ActionHistoryMapperImpl;


public interface ActionHistoryMapper {
	
	ActionHistoryMapper INSTANCE = new ActionHistoryMapperImpl();
	
	
	ActionHistory actionHistoryInDTOtoActionHistory(ActionHistoryInDTO actionHistoryInDTO);
	
	ActionHistoryDTO actionHistorytoActionHistoryDTO(ActionHistory actionHistory);
}
