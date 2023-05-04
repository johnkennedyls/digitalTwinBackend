package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state_alarm database table.
 * 
 */
@Entity
@Table(name="state_alarm")
@NamedQuery(name="StateAlarm.findAll", query="SELECT s FROM StateAlarm s")
public class StateAlarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_alarm_id")
	private Integer stateAlarmId;

	@Column(name="state_alarm_description")
	private String stateAlarmDescription;

	@Column(name="state_alarm_name")
	private String stateAlarmName;

	//bi-directional many-to-one association to Alarm
	@OneToMany(mappedBy="stateAlarm")
	private List<Alarm> alarms;

	//bi-directional many-to-one association to StateAlarm
	@ManyToOne
	@JoinColumn(name="state_in_process_id")
	private StateAlarm stateAlarm;

	//bi-directional many-to-one association to StateAlarm
	@OneToMany(mappedBy="stateAlarm")
	private List<StateAlarm> stateAlarms;

	public StateAlarm() {
	}

	public Integer getStateAlarmId() {
		return this.stateAlarmId;
	}

	public void setStateAlarmId(Integer stateAlarmId) {
		this.stateAlarmId = stateAlarmId;
	}

	public String getStateAlarmDescription() {
		return this.stateAlarmDescription;
	}

	public void setStateAlarmDescription(String stateAlarmDescription) {
		this.stateAlarmDescription = stateAlarmDescription;
	}

	public String getStateAlarmName() {
		return this.stateAlarmName;
	}

	public void setStateAlarmName(String stateAlarmName) {
		this.stateAlarmName = stateAlarmName;
	}

	public List<Alarm> getAlarms() {
		return this.alarms;
	}

	public void setAlarms(List<Alarm> alarms) {
		this.alarms = alarms;
	}

	public Alarm addAlarm(Alarm alarm) {
		getAlarms().add(alarm);
		alarm.setStateAlarm(this);

		return alarm;
	}

	public Alarm removeAlarm(Alarm alarm) {
		getAlarms().remove(alarm);
		alarm.setStateAlarm(null);

		return alarm;
	}

	public StateAlarm getStateAlarm() {
		return this.stateAlarm;
	}

	public void setStateAlarm(StateAlarm stateAlarm) {
		this.stateAlarm = stateAlarm;
	}

	public List<StateAlarm> getStateAlarms() {
		return this.stateAlarms;
	}

	public void setStateAlarms(List<StateAlarm> stateAlarms) {
		this.stateAlarms = stateAlarms;
	}

	public StateAlarm addStateAlarm(StateAlarm stateAlarm) {
		getStateAlarms().add(stateAlarm);
		stateAlarm.setStateAlarm(this);

		return stateAlarm;
	}

	public StateAlarm removeStateAlarm(StateAlarm stateAlarm) {
		getStateAlarms().remove(stateAlarm);
		stateAlarm.setStateAlarm(null);

		return stateAlarm;
	}

}