package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.util.ArrayList;
import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;

	public class TypeAlarmDTO {
		
		private String typeAlarmName;
		private String typeAlarmDescription;
	    private String condition;
	    private Integer numberAlarmsMax;
		private Integer plant_id;
		private Integer event_id;
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
    public Integer getNumberAlarmsMax() {
		return numberAlarmsMax;
	}
	public void setNumberAlarmsMax(Integer numberAlarmsMax) {
		this.numberAlarmsMax = numberAlarmsMax;
	}
	public Integer getPlant_id() {
		return plant_id;
	}
	public void setPlant_id(Integer plant_id) {
		this.plant_id = plant_id;
	}
	public Integer getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}
	public List<AssignedUser> assignedUserListDTOoAssignedUserList() {
		 if ( this.usersAssigned == null ) {
	            return null;
	        }
		 
		 List<AssignedUser> list = new ArrayList<AssignedUser>( this.usersAssigned.size() );
		 
		  for ( String assignedUser : this.usersAssigned ) {
			  AssignedUser newUser= new AssignedUser();
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
	public String toString() {
        return "TypeAlarmDTO{" +
                "typeAlarmName='" + typeAlarmName + '\'' +
                ", typeAlarmDescription='" + typeAlarmDescription + '\'' +
                ", condition='" + condition + '\'' +
                ", numberAlarmsMax=" + numberAlarmsMax +
                ", plant_id=" + plant_id +
                ", event_id=" + event_id +
                ", usersAssigned=" + usersAssigned +
                '}';
    }


}
