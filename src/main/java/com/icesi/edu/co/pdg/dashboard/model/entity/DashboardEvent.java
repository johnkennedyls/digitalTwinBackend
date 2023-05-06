package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.List;


/**
 * The persistent class for the dashboard_event database table.
 * 
 */
@Entity
@NamedQuery(name="DashboardEvent.findAll", query="SELECT d FROM DashboardEvent d")
public class DashboardEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="event_id")
	private Integer eventId;

	@Column(name="event_description")
	private String eventDescription;

	@Column(name="event_name")
	private String eventName;

	@Column(name="type_alarm_id")
	private Integer typeAlarmId;

	//bi-directional many-to-one association to TypeAlarm
	@OneToMany(mappedBy="dashboardEvent")
	private List<TypeAlarm> typeAlarms;

	public DashboardEvent() {
	}

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventDescription() {
		return this.eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getTypeAlarmId() {
		return this.typeAlarmId;
	}

	public void setTypeAlarmId(Integer typeAlarmId) {
		this.typeAlarmId = typeAlarmId;
	}

	public List<TypeAlarm> getTypeAlarms() {
		return this.typeAlarms;
	}

	public void setTypeAlarms(List<TypeAlarm> typeAlarms) {
		this.typeAlarms = typeAlarms;
	}

	public TypeAlarm addTypeAlarm(TypeAlarm typeAlarm) {
		getTypeAlarms().add(typeAlarm);
		typeAlarm.setDashboardEvent(this);

		return typeAlarm;
	}

	public TypeAlarm removeTypeAlarm(TypeAlarm typeAlarm) {
		getTypeAlarms().remove(typeAlarm);
		typeAlarm.setDashboardEvent(null);

		return typeAlarm;
	}

}