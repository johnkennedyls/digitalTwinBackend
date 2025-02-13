package com.icesi.edu.co.pdg.dashboard.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the alarm database table.
 * 
 */
@Entity
@NamedQuery(name="Alarm.findAll", query="SELECT a FROM Alarm a")
public class Alarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="alarm_id")
	@SequenceGenerator(name = "DASHBOARD_ALARM_ALARMID_GENERATOR", sequenceName = "dashboard_alarm_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DASHBOARD_ALARM_ALARMID_GENERATOR")
	private Integer alarmId;

	@Column(name="activation_date")
	private Timestamp activationDate;
	
	@Column(name="tag_value")
	private double tagValue;

	//bi-directional many-to-one association to ActionHistory
	@OneToMany(mappedBy="alarm")
	private List<ActionHistory> actionHistories;

	//bi-directional many-to-one association to StateAlarm
	@ManyToOne
	@JoinColumn(name="state_alarm_id")
	private StateAlarm stateAlarm;

	//bi-directional many-to-one association to TypeAlarm
	@ManyToOne
	@JoinColumn(name="type_alarm_id")
	private TypeAlarm typeAlarm;

	public Alarm() {
	}

	public Integer getAlarmId() {
		return this.alarmId;
	}

	public void setAlarmId(Integer alarmId) {
		this.alarmId = alarmId;
	}

	public Timestamp getActivationDate() {
		return this.activationDate;
	}

	public void setActivationDate(Timestamp activationDate) {
		this.activationDate = activationDate;
	}

	public List<ActionHistory> getActionHistories() {
		return this.actionHistories;
	}

	public void setActionHistories(List<ActionHistory> actionHistories) {
		this.actionHistories = actionHistories;
	}

	public ActionHistory addActionHistory(ActionHistory actionHistory) {
		getActionHistories().add(actionHistory);
		actionHistory.setAlarm(this);

		return actionHistory;
	}

	public ActionHistory removeActionHistory(ActionHistory actionHistory) {
		getActionHistories().remove(actionHistory);
		actionHistory.setAlarm(null);

		return actionHistory;
	}

	public StateAlarm getStateAlarm() {
		return this.stateAlarm;
	}

	public void setStateAlarm(StateAlarm stateAlarm) {
		this.stateAlarm = stateAlarm;
	}

	public TypeAlarm getTypeAlarm() {
		return this.typeAlarm;
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


}