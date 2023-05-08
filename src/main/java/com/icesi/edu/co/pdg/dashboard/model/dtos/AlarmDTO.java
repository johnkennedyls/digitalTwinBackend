package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.sql.Timestamp;

import com.icesi.edu.co.pdg.dashboard.model.entity.StateAlarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;

public class AlarmDTO {
	
	private TypeAlarm typeAlarm;
	private Timestamp activationDate;
	private double tagValue;
	private StateAlarm stateAlarm;
	
	public TypeAlarm getTypeAlarm() {
		return typeAlarm;
	}
	public void setTypeAlarm(TypeAlarm typeAlarm) {
		this.typeAlarm = typeAlarm;
	}
	public double getTagValue() {
		return tagValue;
	}
	public void setTagValue(double tagValue) {
		this.tagValue = tagValue;
	}
	public StateAlarm getStateAlarm() {
		return stateAlarm;
	}
	public void setStateAlarm(StateAlarm stateAlarm) {
		this.stateAlarm = stateAlarm;
	}
	public Timestamp getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Timestamp activationDate) {
		this.activationDate = activationDate;
	}
}
