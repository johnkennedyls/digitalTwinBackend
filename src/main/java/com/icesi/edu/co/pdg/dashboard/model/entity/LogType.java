package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the log_type database table.
 * 
 */
@Entity
@NamedQuery(name="LogType.findAll", query="SELECT l FROM LogType l")
public class LogType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="log_type_id")
	private Integer logTypeId;

	@Column(name="log_type_description")
	private String logTypeDescription;

	@Column(name="log_type_name")
	private String logTypeName;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="logType")
	private List<Log> logs;

	public LogType() {
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

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Log addLog(Log log) {
		getLogs().add(log);
		log.setLogType(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
		log.setLogType(null);

		return log;
	}

}