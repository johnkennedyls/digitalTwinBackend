package com.icesi.edu.co.pdg.dashboard.services.imp;

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
	public void save(String logTypeName, LogDashboard log) throws Exception {
		LogTypeDashboard logtype=logTypeDashboardRepository.findByLogTypeName(logTypeName);
		if(logtype!=null) {
			log.setLogType(logtype);
			logDashboardRepository.save(log);
		}else {
			throw new NoResultException();
		}
	}

}
