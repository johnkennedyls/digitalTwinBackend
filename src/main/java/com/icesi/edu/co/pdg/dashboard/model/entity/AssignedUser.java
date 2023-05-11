
package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name="AssignedUser.findAll", query="SELECT a FROM AssignedUser a")
public class AssignedUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="assigned_users_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer assignedUsersId;

	private String email;


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


	public TypeAlarm getTypeAlarm() {
		return this.typeAlarm;
	}

	public void setTypeAlarm(TypeAlarm typeAlarm) {
		this.typeAlarm = typeAlarm;
	}

}

