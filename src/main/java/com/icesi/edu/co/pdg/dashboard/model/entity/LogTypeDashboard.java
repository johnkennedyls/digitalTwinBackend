package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the log_type database table.
 * 
 */
@Entity
@NamedQuery(name="LogTypeDashboard.findAll", query="SELECT ltd FROM LogTypeDashboard ltd")
public class LogTypeDashboard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="log_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer logTypeId;

	@Column(name="log_type_description")
	private String logTypeDescription;

	@Column(name="log_type_name")
	private String logTypeName;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="logType")
	private List<LogDashboard> logs;

	public LogTypeDashboard() {
	}

	public Integer getLogTypeId() {
		return this.logTypeId;
	}

	public void setLogTypeId(Integer logTypeId) {
		this.logTypeId = logTypeId;
	}

	public String getLogTypeDescription() {
		return this.logTypeDescription;
	}

	public void setLogTypeDescription(String logTypeDescription) {
		this.logTypeDescription = logTypeDescription;
	}

	public String getLogTypeName() {
		return this.logTypeName;
	}

	public void setLogTypeName(String logTypeName) {
		this.logTypeName = logTypeName;
	}

	public List<LogDashboard> getLogs() {
		return this.logs;
	}

	public void setLogs(List<LogDashboard> logs) {
		this.logs = logs;
	}

	public LogDashboard addLog(LogDashboard log) {
		getLogs().add(log);
		log.setLogType(this);

		return log;
	}

	public LogDashboard removeLog(LogDashboard log) {
		getLogs().remove(log);
		log.setLogType(null);

		return log;
	}

}