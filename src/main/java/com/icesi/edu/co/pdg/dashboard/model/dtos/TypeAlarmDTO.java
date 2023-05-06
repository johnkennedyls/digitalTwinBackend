package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;

public class TypeAlarmDTO {
	
	private String typeAlarmName;
	private String typeAlarmDescription;
	private String tagName;
    private String condition;
    private List<AssignedUser> usersAssigned;
	
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
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public List<AssignedUser> getUsersAssigned() {
		return usersAssigned;
	}
	public void setUsersAssigned(List<AssignedUser> usersAssigned) {
		this.usersAssigned = usersAssigned;
	}


}
