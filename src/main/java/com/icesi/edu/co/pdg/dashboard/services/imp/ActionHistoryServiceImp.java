package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ActionHistoryInDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.ActionHistoryMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.ActionHistoryRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.AlarmRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.ActionHistoryService;

@Service
@Transactional
public class ActionHistoryServiceImp implements ActionHistoryService{
	
	@Autowired
	private AlarmRepository alarmRepository;
	@Autowired
	private ActionHistoryRepository actionHistoryRepository;


	@Override
	public ActionHistoryDTO addActionHistory(ActionHistoryInDTO actionHistory,Integer alarmid) throws Exception {
		if(alarmid<0 || alarmid==null || actionHistory.getActionHistoryDescription()==null || actionHistory.getActionHistoryDescription().isEmpty()) {
			throw new BadRequestDataException();
		}else {
			Optional<Alarm> alarm=alarmRepository.findById(alarmid);
			if(alarm.isEmpty()) {
				throw new NoResultException();
			}
			else {
				ActionHistory action=ActionHistoryMapper.INSTANCE.actionHistoryInDTOtoActionHistory(actionHistory);
				Instant instant = Instant.now();
				Timestamp timestamp = Timestamp.from(instant);
				action.setActionHistoryDate(timestamp);
				action.setAlarm(alarm.get());
				action.setActionHistoryUsername("CPASUY");
				action=actionHistoryRepository.save(action);
				ActionHistoryDTO actionHistoryDTO=ActionHistoryMapper.INSTANCE.actionHistorytoActionHistoryDTO(action);
				return actionHistoryDTO;
			}
		}
	}

	@Override
	public List<ActionHistoryDTO> getAllActionsHistoryByAlarmId(Integer alarmid) throws Exception {
		List<ActionHistory> actionHistories = actionHistoryRepository.findAll();
        List<ActionHistoryDTO> actionHistoriesDTO = new ArrayList<ActionHistoryDTO>();
            for(ActionHistory actionHistory:actionHistories) {
            	ActionHistoryDTO actionHistoryDTO=ActionHistoryMapper.INSTANCE.actionHistorytoActionHistoryDTO(actionHistory);
            	actionHistoriesDTO.add(actionHistoryDTO);
            }
                       
            return actionHistoriesDTO;
	}

}
