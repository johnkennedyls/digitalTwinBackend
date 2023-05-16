package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import java.sql.Timestamp;
import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.ActionHistoryDTO;

public class AlarmDetailOutDTO {
	
	private String typeAlarmName;
	private String plantName;
	private Timestamp activationDate;
	private double tagValue;
	private String stateAlarmName;
	private String condition;
    private List<String> usersAssigned;
    private List<ActionHistoryDTO> actionsHistory;
	
	public String getTypeAlarmName() {
		return typeAlarmName;
	}
	public void setTypeAlarmName(String typeAlarmName) {
		this.typeAlarmName = typeAlarmName;
	}
	public double getTagValue() {
		return tagValue;
	}
	public void setTagValue(double tagValue) {
		this.tagValue = tagValue;
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
	public List<ActionHistoryDTO> getActionsHistory() {
		return actionsHistory;
	}
	public void setActionsHistory(List<ActionHistoryDTO> actionsHistory) {
		this.actionsHistory = actionsHistory;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
    public String getStateAlarmName() {
		return stateAlarmName;
	}
	public void setStateAlarmName(String stateAlarmName) {
		this.stateAlarmName = stateAlarmName;
	}
	public Timestamp getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Timestamp activationDate) {
		this.activationDate = activationDate;
	}
}
