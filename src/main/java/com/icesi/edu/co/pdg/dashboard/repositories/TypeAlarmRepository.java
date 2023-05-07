package com.icesi.edu.co.pdg.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;

public interface TypeAlarmRepository extends JpaRepository<TypeAlarm, Integer> {
	
	public TypeAlarm findByTypeAlarmName(String name);
	
	public TypeAlarm findByCondition(String condition);

}
