package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import java.util.ArrayList;
import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AssignedUserDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;
import com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces.AssignedUserMapper;

public class AssignedUserMapperImp implements AssignedUserMapper{

	@Override
	public List<AssignedUser> assignedUserDTOToAssignedUser(List<AssignedUserDTO> assignedUsersDTO) {
		if ( assignedUsersDTO == null ) {
            return null;
        }

        List<AssignedUser> list = new ArrayList<AssignedUser>( assignedUsersDTO.size() );
        for ( AssignedUserDTO assignedUserDTO : assignedUsersDTO ) {
        	AssignedUser assignedUser = new AssignedUser();
    		
        	assignedUser.setEmail(assignedUserDTO.getEmail());;
        	assignedUser.setUsername(assignedUserDTO.getUsername());
            list.add( assignedUser );
        }
        return list;
	}

	@Override
	public List<AssignedUserDTO> assignedUserToAssignedUserDTO(List<AssignedUser> assignedUsers) {
		if ( assignedUsers == null ) {
            return null;
        }

        List<AssignedUserDTO> list = new ArrayList<AssignedUserDTO>( assignedUsers.size() );
        for ( AssignedUser assignedUser : assignedUsers ) {
        	AssignedUserDTO assignedUserDTO = new AssignedUserDTO();
    		
        	assignedUserDTO.setEmail(assignedUser.getEmail());;
        	assignedUserDTO.setUsername(assignedUser.getUsername());
            list.add( assignedUserDTO );
        }
        return list;
	}

}
