package com.icesi.edu.co.pdg.dashboard.model.dtos.in;

public class ActionHistoryInDTO {
	
	private String actionHistoryDescription;


	
	public String getActionHistoryDescription() {
		return actionHistoryDescription;
	}

	public void setActionHistoryDescription(String actionHistoryDescription) {
		this.actionHistoryDescription = actionHistoryDescription;
	}

	public String toString() {
        return "ActionHistoryInDTO{" +
                "actionHistoryDescription='" + actionHistoryDescription + '\'' +
                '}';
    }

}
