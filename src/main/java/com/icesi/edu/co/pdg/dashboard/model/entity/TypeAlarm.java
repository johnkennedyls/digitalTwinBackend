package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * The persistent class for the type_alarm database table.
 * 
 */
@Entity
@Table(name = "type_alarm")
@NamedQuery(name="TypeAlarm.findAll", query="SELECT t FROM TypeAlarm t")
public class TypeAlarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_alarm_seq_gen")
    @SequenceGenerator(name = "type_alarm_seq_gen", sequenceName = "type_alarm_seq")
	private Integer typeAlarmId;

	private String condition;	

	private Integer numberAlarmsMax;

	@Column(name="type_alarm_description")
	private String typeAlarmDescription;

	@Column(name="type_alarm_name")
	private String typeAlarmName;
	
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
	public Integer getNumberAlarmsMax() {
		return numberAlarmsMax;
	}

	public void setNumberAlarmsMax(Integer numberAlarmsMax) {
		this.numberAlarmsMax = numberAlarmsMax;
	}
	public List<String> getEmailsAssignedUsers() {
		 if ( this.assignedUsers == null ) {
	            return null;
	        }
		 
		 List<String> list = new ArrayList<String>( this.assignedUsers.size() );
		 
		  for ( AssignedUser assignedUser : this.assignedUsers ) {
			  String email= assignedUser.getEmail();
			  list.add(email);
	        }
		  
		  return list;
		 
	}
	

}