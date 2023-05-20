package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.entity.LogDashboard;
import com.icesi.edu.co.pdg.dashboard.model.entity.LogTypeDashboard;
import com.icesi.edu.co.pdg.dashboard.repositories.LogDashboardRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.LogTypeDashboardRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.LogDashboardService;

@Service
public class LogDashboardServiceImp implements LogDashboardService{
	
	@Autowired
	LogDashboardRepository logDashboardRepository;
	@Autowired
	LogTypeDashboardRepository logTypeDashboardRepository;

	@Override
	public void save(String logTypeName, String description) throws Exception {
		LogTypeDashboard logtype=logTypeDashboardRepository.findByLogTypeName(logTypeName);
		if(logtype!=null) {
			LogDashboard log =new LogDashboard();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			log.setLogDate(timestamp);
			log.setLogType(logtype);
			log.setLoggedUser("yo");
			log.setDetailLog(description);
			logDashboardRepository.save(log);
		}else {
			throw new NoResultException();
		}
	}


}
