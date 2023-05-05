package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;


public class AlarmDetailOutDTO {
	
	private String typeAlarmName;
	private String typeAlarmDescription;
	private String tagName;
    private String condition;
    private List<String> usersAssigned;
    private List<ActionHistory> actionsHistory;
	
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
	public List<String> getUsersAssigned() {
		return usersAssigned;
	}
	public void setUsersAssigned(List<String> usersAssigned) {
		this.usersAssigned = usersAssigned;
	}
	public List<ActionHistory> getActionsHistory() {
		return actionsHistory;
	}
	public void setActionsHistory(List<ActionHistory> actionsHistory) {
		this.actionsHistory = actionsHistory;
	}

}
