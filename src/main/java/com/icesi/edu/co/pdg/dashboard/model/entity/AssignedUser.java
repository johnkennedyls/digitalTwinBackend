package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the assigned_users database table.
 * 
 */
@Entity
@Table(name="assigned_users")
@NamedQuery(name="AssignedUser.findAll", query="SELECT a FROM AssignedUser a")
public class AssignedUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="assigned_users_id")
	private Integer assignedUsersId;

	private String email;

	private String username;

	//bi-directional many-to-one association to TypeAlarm
	@ManyToOne
	@JoinColumn(name="type_alarm_id")
	private TypeAlarm typeAlarm;

	public AssignedUser() {
	}

	public Integer getAssignedUsersId() {
		return this.assignedUsersId;
	}

	public void setAssignedUsersId(Integer assignedUsersId) {
		this.assignedUsersId = assignedUsersId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TypeAlarm getTypeAlarm() {
		return this.typeAlarm;
	}

	public void setTypeAlarm(TypeAlarm typeAlarm) {
		this.typeAlarm = typeAlarm;
	}

}