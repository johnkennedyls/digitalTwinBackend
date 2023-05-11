package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;


/**
 * The persistent class for the action_history database table.
 * 
 */
@Entity
@NamedQuery(name="ActionHistory.findAll", query="SELECT a FROM ActionHistory a")
public class ActionHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_history_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer actionHistoryId;

	@Column(name="action_history_date")
	private Timestamp actionHistoryDate;

	@Column(name="action_history_description")
	private String actionHistoryDescription;

	@Column(name="action_history_email")
	private String actionHistoryEmail;

	@Column(name="action_history_username")
	private String actionHistoryUsername;

	//bi-directional many-to-one association to Alarm
	@ManyToOne
	@JoinColumn(name="alarm_id")
	private Alarm alarm;

	public ActionHistory() {
	}

	public Integer getActionHistoryId() {
		return this.actionHistoryId;
	}

	public void setActionHistoryId(Integer actionHistoryId) {
		this.actionHistoryId = actionHistoryId;
	}

	public Timestamp getActionHistoryDate() {
		return this.actionHistoryDate;
	}

	public void setActionHistoryDate(Timestamp actionHistoryDate) {
		this.actionHistoryDate = actionHistoryDate;
	}

	public String getActionHistoryDescription() {
		return this.actionHistoryDescription;
	}

	public void setActionHistoryDescription(String actionHistoryDescription) {
		this.actionHistoryDescription = actionHistoryDescription;
	}

	public String getActionHistoryEmail() {
		return this.actionHistoryEmail;
	}

	public void setActionHistoryEmail(String actionHistoryEmail) {
		this.actionHistoryEmail = actionHistoryEmail;
	}

	public String getActionHistoryUsername() {
		return this.actionHistoryUsername;
	}

	public void setActionHistoryUsername(String actionHistoryUsername) {
		this.actionHistoryUsername = actionHistoryUsername;
	}

	public Alarm getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}

}