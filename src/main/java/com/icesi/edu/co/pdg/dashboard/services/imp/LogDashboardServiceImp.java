package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.sql.Timestamp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
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
	
		this.logDashboardRepository=logDashboardRepository;
		this.logTypeDashboardRepository=logTypeDashboardRepository;
	}
	
	 @PostConstruct
	    public void init() {
	        System.out.println(saamfiUrl);
	        saamfiDelegate = new SaamfiDelegate(saamfiUrl);  
	        info = logTypeDashboardRepository.findByLogTypeName("INFO");
	        warn = logTypeDashboardRepository.findByLogTypeName("WARN");
	        error = logTypeDashboardRepository.findByLogTypeName("ERROR");
	    }
	@Override
	public void save(String logTypeName, String description) throws Exception {		
		if(!logTypeName.isEmpty()) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null) {
			    String token = (String) authentication.getCredentials();
			    if(token!=null) {
			    	if(logTypeName.equals(info.getLogTypeName()) && info!=null) {
			    		LogDashboard log =new LogDashboard();
			    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						log.setLogDate(timestamp);
						log.setLogType(info);
						log.setLoggedUser(saamfiDelegate.getUsernameFromJWT(token));
						log.setDetailLog(description);
						save(log);
			    	}				
			    	else if(logTypeName.equals(warn.getLogTypeName()) && info!=null) {
			    		LogDashboard log =new LogDashboard();
			    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						log.setLogDate(timestamp);
						log.setLogType(warn);
						log.setLoggedUser(saamfiDelegate.getUsernameFromJWT(token));
						log.setDetailLog(description);
						save(log);
					}else if(logTypeName.equals(error.getLogTypeName()) && warn!=null) {
						LogDashboard log =new LogDashboard();
			    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						log.setLogDate(timestamp);
						log.setLogType(error);
						log.setLoggedUser(saamfiDelegate.getUsernameFromJWT(token));
						log.setDetailLog(description);
						save(log);
					}
				}
			}
			
		}else {
			throw new BadRequestDataException();
		}
	}
	@Override
	public void save(LogDashboard log) throws Exception {		
		logDashboardRepository.save(log);
	}


}
