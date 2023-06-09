package com.icesi.edu.co.pdg.dashboard.model.mappers;

import java.util.List;


import com.icesi.edu.co.pdg.dashboard.model.dtos.AssignedUserDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;
import com.icesi.edu.co.pdg.dashboard.model.mappers.imp.AssignedUserMapperImpl;

public interface AssignedUserMapper {
	
	AssignedUserMapper INSTANCE = new AssignedUserMapperImpl();
	
	List<AssignedUser> assignedUserDTOToAssignedUser(List<AssignedUserDTO> assignedUsersDTO);
	
	List<AssignedUserDTO> assignedUserToAssignedUserDTO(List<AssignedUser> assignedUsers);
	

}
