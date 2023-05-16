package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.sql.Timestamp;


public class ActionHistoryDTO {
	
	private Timestamp actionHistoryDate;

	private String actionHistoryDescription;

	private String actionHistoryUsername;
	
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
