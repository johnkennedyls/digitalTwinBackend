
package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name="AssignedUser.findAll", query="SELECT a FROM AssignedUser a")
public class AssignedUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="assigned_users_id")
	@SequenceGenerator(name = "DASHBOARD_ASSIGNEDUSER_ASSIGNEDUSERID_GENERATOR", sequenceName = "dashboard_assigned_users_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DASHBOARD_ASSIGNEDUSER_ASSIGNEDUSERID_GENERATOR")
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

