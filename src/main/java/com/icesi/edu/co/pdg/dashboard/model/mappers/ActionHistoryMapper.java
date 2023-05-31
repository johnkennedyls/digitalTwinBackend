package com.icesi.edu.co.pdg.dashboard.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;


@Mapper
public interface ActionHistoryMapper {
	
	ActionHistoryMapper INSTANCE = Mappers.getMapper(ActionHistoryMapper.class);
	
	ActionHistory actionHistoryInDTOtoActionHistory(ActionHistoryInDTO actionHistoryInDTO);
	
	ActionHistoryDTO actionHistorytoActionHistoryDTO(ActionHistory actionHistory);
}
