package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the state_alarm database table.
 * 
 */
@Entity
@NamedQuery(name="StateAlarm.findAll", query="SELECT s FROM StateAlarm s")
public class StateAlarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_alarm_id")
	@SequenceGenerator(name = "DASHBOARD_STATEALARM_STATEALARMID_GENERATOR", sequenceName = "dashboard_state_alarm_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DASHBOARD_STATEALARM_STATEALARMID_GENERATOR")
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