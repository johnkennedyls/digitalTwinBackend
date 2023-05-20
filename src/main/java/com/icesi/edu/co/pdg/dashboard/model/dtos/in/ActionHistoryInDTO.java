package com.icesi.edu.co.pdg.dashboard.model.dtos.in;

public class ActionHistoryInDTO {
	
	private String actionHistoryDescription;

	private String actionHistoryUsername;

	
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
	public String toString() {
        return "ActionHistoryInDTO{" +
                "actionHistoryDescription='" + actionHistoryDescription + '\'' +
                ", actionHistoryUsername='" + actionHistoryUsername + '\'' +
                '}';
    }

}
