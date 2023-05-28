package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.sql.Timestamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.model.entity.LogDashboard;
import com.icesi.edu.co.pdg.dashboard.model.entity.LogTypeDashboard;
import com.icesi.edu.co.pdg.dashboard.repositories.LogDashboardRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.LogTypeDashboardRepository;
import com.icesi.edu.co.pdg.dashboard.security.SaamfiUserDetails;
import com.icesi.edu.co.pdg.dashboard.security.SecurityUtils;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.LogDashboardService;

@Service
public class LogDashboardServiceImp implements LogDashboardService{
	
	LogDashboardRepository logDashboardRepository;
	LogTypeDashboardRepository logTypeDashboardRepository;
	
	LogTypeDashboard info;
	LogTypeDashboard warn;
	LogTypeDashboard error;

	@Autowired
	public LogDashboardServiceImp(LogDashboardRepository logDashboardRepository,LogTypeDashboardRepository logTypeDashboardRepository) {
		this.logDashboardRepository=logDashboardRepository;
		this.logTypeDashboardRepository=logTypeDashboardRepository;
		info=logTypeDashboardRepository.findByLogTypeName("INFO");
		warn=logTypeDashboardRepository.findByLogTypeName("WARN");
		error=logTypeDashboardRepository.findByLogTypeName("ERROR");
	}

	@Override
	public void save(String logTypeName, String description) throws Exception {		
		if(!logTypeName.isEmpty()) {
			SaamfiUserDetails userDetails = SecurityUtils.getCurrentUser();
			LogDashboard log =new LogDashboard();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			log.setLogDate(timestamp);
			if(logTypeName.equals(info.getLogTypeName())) {
				log.setLogType(info);
			}else if(logTypeName.equals(warn.getLogTypeName())) {
				log.setLogType(warn);
			}else {
				log.setLogType(error);
			}
			log.setLoggedUser(userDetails.getUsername());
			log.setDetailLog(description);
			logDashboardRepository.save(log);
		}else {
			throw new BadRequestDataException();
		}
	}


}
