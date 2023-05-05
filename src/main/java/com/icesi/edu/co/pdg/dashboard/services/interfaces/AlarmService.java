package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.AlarmCommentInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.AlarmGenerateInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;

public interface AlarmService {
	
	public List<AlarmListOutDTO> getAllAlarms () throws Exception;
	
	public Alarm addAlarm(AlarmGenerateInDTO alarm) throws Exception;
	
	public Alarm editAlarm(AlarmCommentInDTO alarm) throws Exception;

}
