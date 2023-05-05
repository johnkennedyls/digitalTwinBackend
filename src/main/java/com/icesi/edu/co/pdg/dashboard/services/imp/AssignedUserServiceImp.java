package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.AssignedUserDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces.AssignedUserMapper;
import com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces.TypeAlarmMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.AssignedUserRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.TypeAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AssignedUserService;

public class AssignedUserServiceImp implements AssignedUserService{

	@Autowired
    private AssignedUserRepository assignedUserRepository;
	@Autowired
    private TypeAlarmRepository typeAlarmRepository;

	@Override
	public List<AssignedUserDTO> getAllAssignedUserByTypeAlarm(Integer typeAlarmid) throws Exception {
		if( typeAlarmid<0 || typeAlarmid==null) {
			throw new BadRequestDataException();
		}else {
			List<AssignedUser>  assignedUsers= new ArrayList<AssignedUser>();
			Optional<TypeAlarm> typeAlarm=typeAlarmRepository.findById(typeAlarmid);
			if(!typeAlarm.isEmpty()) {
				assignedUsers=assignedUserRepository.findByTypeAlarmTypeAlarmId(typeAlarmid);
				if(assignedUsers.isEmpty()) {
					throw new NoResultException();
		        }else {
		        	List<AssignedUserDTO> assignedUsersDTO = AssignedUserMapper.INSTANCE.assignedUserToAssignedUserDTO(assignedUsers);
		    		return assignedUsersDTO;
		        }
			}else {
				throw new NoResultException();
			}
		}
	}

	@Override
	public List<AssignedUser> addAssignedUser(List<AssignedUser> assignedUsers, Integer typeAlarmid) throws Exception {
		if(assignedUsers==null || typeAlarmid<0 || typeAlarmid==null) {
			throw new BadRequestDataException();
		}else {
			Optional<TypeAlarm> typeAlarm=typeAlarmRepository.findById(typeAlarmid);
			if(!typeAlarm.isEmpty()) {
				for (AssignedUser user : assignedUsers ) {
					user.setTypeAlarm(typeAlarm.get());	        	
		        }
				assignedUsers=assignedUserRepository.saveAll(assignedUsers);
				return assignedUsers;
			}else {
				throw new NoResultException();
			}
			
		}
	}
	

	@Override
	public void deleteByTypeAlarmTypeAlarmId(Integer typeAlarmid) throws Exception {
		if( typeAlarmid<0 || typeAlarmid==null) {
			throw new BadRequestDataException();
		}else {
			Optional<TypeAlarm> typeAlarm=typeAlarmRepository.findById(typeAlarmid);
			if(!typeAlarm.isEmpty()) {
				assignedUserRepository.deleteByTypeAlarmTypeAlarmId(typeAlarmid);
			}else {
				throw new NoResultException();
			}
		}
		
	}

}
