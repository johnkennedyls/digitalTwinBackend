package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.util.ArrayList;
import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;

	public class TypeAlarmDTO {
		
		private String typeAlarmName;
		private String typeAlarmDescription;
	    private String condition;
	    private List<String> usersAssigned;
	
	public String getTypeAlarmName() {
		return typeAlarmName;
	}
	public void setTypeAlarmName(String typeAlarmName) {
		this.typeAlarmName = typeAlarmName;
	}
	public String getTypeAlarmDescription() {
		return typeAlarmDescription;
	}
	public void setTypeAlarmDescription(String typeAlarmDescription) {
		this.typeAlarmDescription = typeAlarmDescription;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public List<String> getUsersAssigned() {
		return usersAssigned;
	}
	public void setUsersAssigned(List<String> usersAssigned) {
		this.usersAssigned = usersAssigned;
	}
	public List<AssignedUser> assignedUserListDTOoAssignedUserList() {
		 if ( this.usersAssigned == null ) {
	            return null;
	        }
		 
		 List<AssignedUser> list = new ArrayList<AssignedUser>( this.usersAssigned.size() );
		 
		  for ( String assignedUser : this.usersAssigned ) {
			  AssignedUser newUser= new AssignedUser();
			  newUser.setAssignedUsersId(1);
			  newUser.setEmail(assignedUser);
			  list.add(newUser);
	        }
		  
		  return list;
		 
	}
	public List<String> assignedUserListToAssignedUserDTOList( List<AssignedUser> usersAssigned) {
		 if ( usersAssigned == null ) {
	            return null;
	        }
		 
		 List<String> list = new ArrayList<String>( usersAssigned.size() );
		 
		  for ( AssignedUser assignedUser : usersAssigned ) {
			  String email= assignedUser.getEmail();
			  list.add(email);
	        }
		  
		  return list;
		 
	}


}
