package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@NamedQuery(name="LogDashboard.findAll", query="SELECT ld FROM LogDashboard ld")
public class LogDashboard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="log_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer logId;

	@Column(name="detail_log")
	private String detailLog;

	@Column(name="log_date")
	private Timestamp logDate;

	@Column(name="logged_user")
	private String loggedUser;

	//bi-directional many-to-one association to LogType
	@ManyToOne
	@JoinColumn(name="log_type_id")
	private LogTypeDashboard logType;

	public LogDashboard() {
	}

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getDetailLog() {
		return this.detailLog;
	}

	public void setDetailLog(String detailLog) {
		this.detailLog = detailLog;
	}

	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}


	public LogTypeDashboard getLogType() {
		return this.logType;
	}

	public void setLogType(LogTypeDashboard logType) {
		this.logType = logType;
	}
	public String getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
	}

}