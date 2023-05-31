package com.icesi.edu.co.pdg.dashboard.model.mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AssignedUserDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T14:14:21-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
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
