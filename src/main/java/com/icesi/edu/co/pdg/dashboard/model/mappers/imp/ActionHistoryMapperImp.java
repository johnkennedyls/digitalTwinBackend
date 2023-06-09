package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import com.icesi.edu.co.pdg.dashboard.model.mappers.ActionHistoryMapper;

public class ActionHistoryMapperImp implements ActionHistoryMapper{

	@Override
	public ActionHistory actionHistoryInDTOtoActionHistory(ActionHistoryInDTO actionHistoryInDTO) {
		ActionHistory ah = new ActionHistory();
		ah.setActionHistoryDescription(actionHistoryInDTO.getActionHistoryDescription());
		return ah;
	}

	@Override
	public ActionHistoryDTO actionHistorytoActionHistoryDTO(ActionHistory actionHistory) {
		ActionHistoryDTO ahd = new ActionHistoryDTO();
		ahd.setActionHistoryDate(actionHistory.getActionHistoryDate());
		ahd.setActionHistoryDescription(actionHistory.getActionHistoryDescription());
		ahd.setActionHistoryId(actionHistory.getActionHistoryId());
		ahd.setActionHistoryUsername(actionHistory.getActionHistoryUsername());
		return ahd;
	}

}
