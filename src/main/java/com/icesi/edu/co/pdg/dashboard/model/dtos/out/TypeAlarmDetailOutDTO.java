package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import java.util.List;

public class TypeAlarmDetailOutDTO {
	
	private Integer id;
	private String typeAlarmName;
	private String typeAlarmDescription;
    private String condition;
    private Integer numberAlarmsMax;
	private String plantName;
	private String eventName;
	private List<String> usersAssigned;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getNumberAlarmsMax() {
		return numberAlarmsMax;
	}
	public void setNumberAlarmsMax(Integer numberAlarmsMax) {
		this.numberAlarmsMax = numberAlarmsMax;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public List<String> getUsersAssigned() {
		return usersAssigned;
	}
	public void setUsersAssigned(List<String> usersAssigned) {
		this.usersAssigned = usersAssigned;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
