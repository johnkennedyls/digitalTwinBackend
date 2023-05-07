package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AssignedUserDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;

public interface AssignedUserService {
	
	public List<AssignedUserDTO> getAllAssignedUserByTypeAlarm(Integer typeAlarmid) throws Exception;
	public List<AssignedUser> addAssignedUser(List<AssignedUser> assignedUser,Integer typeAlarmid) throws Exception;
	public void deleteByTypeAlarmTypeAlarmId(Integer typeAlarmid) throws Exception;
	

}
