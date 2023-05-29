package com.icesi.edu.co.pdg.dashboard.model.mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AssignedUserDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-28T21:12:54-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230413-0857, environment: Java 17.0.7 (Eclipse Adoptium)"
)
public class AssignedUserMapperImpl implements AssignedUserMapper {

    @Override
    public List<AssignedUser> assignedUserDTOToAssignedUser(List<AssignedUserDTO> assignedUsersDTO) {
        if ( assignedUsersDTO == null ) {
            return null;
        }

        List<AssignedUser> list = new ArrayList<AssignedUser>( assignedUsersDTO.size() );
        for ( AssignedUserDTO assignedUserDTO : assignedUsersDTO ) {
            list.add( assignedUserDTOToAssignedUser( assignedUserDTO ) );
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
            list.add( assignedUserToAssignedUserDTO( assignedUser ) );
        }

        return list;
    }

    protected AssignedUser assignedUserDTOToAssignedUser(AssignedUserDTO assignedUserDTO) {
        if ( assignedUserDTO == null ) {
            return null;
        }

        AssignedUser assignedUser = new AssignedUser();

        assignedUser.setEmail( assignedUserDTO.getEmail() );

        return assignedUser;
    }

    protected AssignedUserDTO assignedUserToAssignedUserDTO(AssignedUser assignedUser) {
        if ( assignedUser == null ) {
            return null;
        }

        AssignedUserDTO assignedUserDTO = new AssignedUserDTO();

        assignedUserDTO.setEmail( assignedUser.getEmail() );

        return assignedUserDTO;
    }
}
