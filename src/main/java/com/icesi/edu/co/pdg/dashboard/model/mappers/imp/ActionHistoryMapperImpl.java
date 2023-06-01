package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import com.icesi.edu.co.pdg.dashboard.model.mappers.ActionHistoryMapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;


public class ActionHistoryMapperImpl implements ActionHistoryMapper {

    @Override
    public ActionHistory actionHistoryInDTOtoActionHistory(ActionHistoryInDTO actionHistoryInDTO) {
        if ( actionHistoryInDTO == null ) {
            return null;
        }

        ActionHistory actionHistory = new ActionHistory();

        actionHistory.setActionHistoryDescription( actionHistoryInDTO.getActionHistoryDescription() );

        return actionHistory;
    }

    @Override
    public ActionHistoryDTO actionHistorytoActionHistoryDTO(ActionHistory actionHistory) {
        if ( actionHistory == null ) {
            return null;
        }

        ActionHistoryDTO actionHistoryDTO = new ActionHistoryDTO();

        actionHistoryDTO.setActionHistoryId( actionHistory.getActionHistoryId() );
        actionHistoryDTO.setActionHistoryDate( actionHistory.getActionHistoryDate() );
        actionHistoryDTO.setActionHistoryDescription( actionHistory.getActionHistoryDescription() );
        actionHistoryDTO.setActionHistoryUsername( actionHistory.getActionHistoryUsername() );

        return actionHistoryDTO;
    }
}
