package com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces;

import java.util.List;

import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AssignedUserDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;
public interface AssignedUserMapper {
	
	AssignedUserMapper INSTANCE = Mappers.getMapper(AssignedUserMapper.class);
	
	List<AssignedUser> assignedUserDTOToAssignedUser(List<AssignedUserDTO> assignedUsersDTO);
	
	List<AssignedUserDTO> assignedUserToAssignedUserDTO(List<AssignedUser> assignedUsers);

}
