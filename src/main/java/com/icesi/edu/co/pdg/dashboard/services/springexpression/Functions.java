package com.icesi.edu.co.pdg.dashboard.services.springexpression;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.repositories.TypeAlarmRepository;


@Service
public class Functions {
	 
	 @Autowired
	 private TypeAlarmRepository typeAlarmRepository;
	 
	 public List<TypeAlarm> loadTypeAlarmsFromDatabase(String name) {
		 return typeAlarmRepository.findByConditionContaining(name);
	 }

}
