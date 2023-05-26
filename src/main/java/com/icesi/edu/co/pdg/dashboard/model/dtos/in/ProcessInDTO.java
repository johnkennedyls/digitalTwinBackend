package com.icesi.edu.co.pdg.dashboard.model.dtos.in;

public class ProcessInDTO {
	private String processName;
	private String processDescription;
	private Integer[] selectedAssets;
	
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getProcessDescription() {
		return processDescription;
	}
	public void setProcessDescription(String processDescription) {
		this.processDescription = processDescription;
	}
	public Integer[] getSelectedAssets() {
		return selectedAssets;
	}
	public void setSelectedAssets(Integer[] selectedAssets) {
		this.selectedAssets = selectedAssets;
	}
}
