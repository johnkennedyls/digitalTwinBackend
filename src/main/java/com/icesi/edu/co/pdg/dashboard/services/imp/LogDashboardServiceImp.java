package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.sql.Timestamp;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.model.entity.LogDashboard;
import com.icesi.edu.co.pdg.dashboard.model.entity.LogTypeDashboard;
import com.icesi.edu.co.pdg.dashboard.repositories.LogDashboardRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.LogTypeDashboardRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.LogDashboardService;

import co.edu.icesi.dev.saamfi.saamfisecurity.delegate.SaamfiDelegate;

@Service
@Transactional
public class LogDashboardServiceImp implements LogDashboardService{
	
	LogDashboardRepository logDashboardRepository;
	LogTypeDashboardRepository logTypeDashboardRepository;
	SaamfiDelegate saamfiDelegate ;	
	LogTypeDashboard info;
	LogTypeDashboard warn;
	LogTypeDashboard error;

    @Value("${saamfi.api.url}")
    private String saamfiUrl;

	@Autowired
	public LogDashboardServiceImp( LogDashboardRepository logDashboardRepository,LogTypeDashboardRepository logTypeDashboardRepository) {
		System.out.println(saamfiUrl);
		
		saamfiDelegate=new SaamfiDelegate("http://xgrid103:8080/saamfiapi");
		this.logDashboardRepository=logDashboardRepository;
		this.logTypeDashboardRepository=logTypeDashboardRepository;
		info=logTypeDashboardRepository.findByLogTypeName("INFO");
		warn=logTypeDashboardRepository.findByLogTypeName("WARN");
		error=logTypeDashboardRepository.findByLogTypeName("ERROR");
	}

	@Override
	public void save(String logTypeName, String description) throws Exception {		
		if(!logTypeName.isEmpty()) {
			String token = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
			if(token!=null) {
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
				log.setLoggedUser(saamfiDelegate.getUsernameFromJWT(token));
				log.setDetailLog(description);
				logDashboardRepository.save(log);
			}
		}else {
			throw new BadRequestDataException();
		}
	}


}
