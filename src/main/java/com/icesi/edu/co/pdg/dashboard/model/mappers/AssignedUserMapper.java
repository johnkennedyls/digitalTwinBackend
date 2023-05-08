package com.icesi.edu.co.pdg.dashboard.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AssignedUserDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;
@Mapper
public interface AssignedUserMapper {
	
	AssignedUserMapper INSTANCE = Mappers.getMapper(AssignedUserMapper.class);
	
	List<AssignedUser> assignedUserDTOToAssignedUser(List<AssignedUserDTO> assignedUsersDTO);
	
	List<AssignedUserDTO> assignedUserToAssignedUserDTO(List<AssignedUser> assignedUsers);
	

}
