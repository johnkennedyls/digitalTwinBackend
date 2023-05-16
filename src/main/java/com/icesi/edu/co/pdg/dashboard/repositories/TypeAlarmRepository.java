package com.icesi.edu.co.pdg.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
@Repository
public interface TypeAlarmRepository extends JpaRepository<TypeAlarm, Integer> {
	
	public TypeAlarm findByTypeAlarmName(String name);
	
	public TypeAlarm findByCondition(String condition);
	
	List<TypeAlarm> findByConditionContaining(String nombre);
	
	List<TypeAlarm> findByPlantPlantId(Integer plantid);

}
