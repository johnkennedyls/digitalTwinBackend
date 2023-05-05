package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.AlarmCommentInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.AlarmGenerateInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AlarmService;

@Service
public class AlarmServiceImp implements AlarmService {


	@Override
	public Alarm addAlarm(AlarmGenerateInDTO alarm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alarm editAlarm(AlarmCommentInDTO alarm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlarmListOutDTO> getAllAlarms() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
