package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

/**
 * The persistent class for the type_alarm database table.
 * 
 */
@Entity
@NamedQuery(name="TypeAlarm.findAll", query="SELECT t FROM TypeAlarm t")
public class TypeAlarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="type_alarm_id")
	private Integer typeAlarmId;

	private String condition;

	@Column(name="type_alarm_description")
	private String typeAlarmDescription;

	@Column(name="type_alarm_name")
	private String typeAlarmName;
	
	@Column(name="tag_name")
	private String tagName;

	//bi-directional many-to-one association to Alarm
	@OneToMany(mappedBy="typeAlarm")
	private List<Alarm> alarms;

	//bi-directional many-to-one association to AssignedUser
	@OneToMany(mappedBy="typeAlarm")
	private List<AssignedUser> assignedUsers;

	//bi-directional many-to-one association to DashboardEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	private DashboardEvent dashboardEvent;

	//bi-directional many-to-one association to Plant
	@ManyToOne
	@JoinColumn(name="plant_id")
	private Plant plant;

	public TypeAlarm() {
	}

	public Integer getTypeAlarmId() {
		return this.typeAlarmId;
	}

	public void setTypeAlarmId(Integer typeAlarmId) {
		this.typeAlarmId = typeAlarmId;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTypeAlarmDescription() {
		return this.typeAlarmDescription;
	}

	public void setTypeAlarmDescription(String typeAlarmDescription) {
		this.typeAlarmDescription = typeAlarmDescription;
	}

	public String getTypeAlarmName() {
		return this.typeAlarmName;
	}

	public void setTypeAlarmName(String typeAlarmName) {
		this.typeAlarmName = typeAlarmName;
	}

	public List<Alarm> getAlarms() {
		return this.alarms;
	}

	public void setAlarms(List<Alarm> alarms) {
		this.alarms = alarms;
	}

	public Alarm addAlarm(Alarm alarm) {
		getAlarms().add(alarm);
		alarm.setTypeAlarm(this);

		return alarm;
	}

	public Alarm removeAlarm(Alarm alarm) {
		getAlarms().remove(alarm);
		alarm.setTypeAlarm(null);

		return alarm;
	}

	public List<AssignedUser> getAssignedUsers() {
		return this.assignedUsers;
	}

	public void setAssignedUsers(List<AssignedUser> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}

	public AssignedUser addAssignedUser(AssignedUser assignedUser) {
		getAssignedUsers().add(assignedUser);
		assignedUser.setTypeAlarm(this);

		return assignedUser;
	}

	public AssignedUser removeAssignedUser(AssignedUser assignedUser) {
		getAssignedUsers().remove(assignedUser);
		assignedUser.setTypeAlarm(null);

		return assignedUser;
	}

	public DashboardEvent getDashboardEvent() {
		return this.dashboardEvent;
	}

	public void setDashboardEvent(DashboardEvent dashboardEvent) {
		this.dashboardEvent = dashboardEvent;
	}

	public Plant getPlant() {
		return this.plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}