package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.StateAlarmOutDTO;

public interface StateAlarmService {
	
	public List<StateAlarmOutDTO> getAllStates() throws Exception;

}
