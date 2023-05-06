package com.icesi.edu.co.pdg.dashboard.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;


public interface AssignedUserRepository  extends JpaRepository<AssignedUser, Integer>{
	
	public List<AssignedUser> findByTypeAlarmTypeAlarmId(Integer typeAlarmid);
	
	public List<AssignedUser> deleteByTypeAlarmTypeAlarmId(Integer typeAlarmid);

}
