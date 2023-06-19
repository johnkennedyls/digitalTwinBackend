package com.icesi.edu.co.pdg.dashboard.model.dtos;

public class TagDTO {
	
	private Integer assetId;
	private String name;
	private String dataType;
	private String description;
	private Character state;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Character getState() {
		return state;
	}
	public void setState(Character state) {
		this.state = state;
	}
	public Integer getAssetId() {
		return assetId;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	} 
}
