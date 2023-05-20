package com.icesi.edu.co.pdg.dashboard.model.dtos;

public class StateAlarmInDTO {
	
	private String stateAlarmName;
	
	public String getStateAlarmName() {
		return stateAlarmName;
	}

	public void setStateAlarmName(String stateAlarmName) {
		this.stateAlarmName = stateAlarmName;
	}
	public String toString() {
        return "StateAlarmInDTO{" +
                "stateAlarmName='" + stateAlarmName + '\'' +
                '}';
    }


}
