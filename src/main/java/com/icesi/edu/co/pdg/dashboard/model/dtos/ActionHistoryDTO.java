package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.sql.Timestamp;


public class ActionHistoryDTO {
	

	private Integer actionHistoryId;
	
	private Timestamp actionHistoryDate;

	private String actionHistoryDescription;

	private String actionHistoryUsername;
	
	public Integer getActionHistoryId() {
		return actionHistoryId;
	}

	public void setActionHistoryId(Integer actionHistoryId) {
		this.actionHistoryId = actionHistoryId;
	}
	
	public Timestamp getActionHistoryDate() {
		return actionHistoryDate;
	}

	public void setActionHistoryDate(Timestamp actionHistoryDate) {
		this.actionHistoryDate = actionHistoryDate;
	}

	public String getActionHistoryDescription() {
		return actionHistoryDescription;
	}

	public void setActionHistoryDescription(String actionHistoryDescription) {
		this.actionHistoryDescription = actionHistoryDescription;
	}

	public String getActionHistoryUsername() {
		return actionHistoryUsername;
	}

	public void setActionHistoryUsername(String actionHistoryUsername) {
		this.actionHistoryUsername = actionHistoryUsername;
	}

}
