package com.icesi.edu.co.pdg.dashboard.model.mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-28T21:12:54-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230413-0857, environment: Java 17.0.7 (Eclipse Adoptium)"
)
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
