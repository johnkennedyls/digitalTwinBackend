package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import java.sql.Timestamp;
import java.util.List;

public class AlarmListOutDTO {
	
	private String typeAlarmName;
	private String plantName;
    private String condition;
	private String stateAlarmName;
    private Timestamp activationDate;
	private List<String> usersAssigned;
    
    public String getTypeAlarmName() {
		return typeAlarmName;
	}
	public void setTypeAlarmName(String typeAlarmName) {
		this.typeAlarmName = typeAlarmName;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
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
	public List<String> getUsersAssigned() {
		return usersAssigned;
	}
	public void setUsersAssigned(List<String> usersAssigned) {
		this.usersAssigned = usersAssigned;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

}
