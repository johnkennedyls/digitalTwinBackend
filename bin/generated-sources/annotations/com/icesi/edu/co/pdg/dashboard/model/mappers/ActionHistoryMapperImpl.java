package com.icesi.edu.co.pdg.dashboard.model.mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T18:04:16-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
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
