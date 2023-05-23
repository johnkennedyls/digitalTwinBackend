package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TagDTO;

public class PlantListOutDTO {
	private Integer plantId;
	private Integer assetId;
	private String plantName; 
	private String plantDescription;
	private String plantPhoto;
	private List<TagDTO> tags;
	
	public Integer getPlantId() {
		return plantId;
	}
	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getPlantDescription() {
		return plantDescription;
	}
	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}
	public String getPlantPhoto() {
		return plantPhoto;
	}
	public void setPlantPhoto(String plantPhoto) {
		this.plantPhoto = plantPhoto;
	}
	public List<TagDTO> getTags() {
		return tags;
	}
	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}
	public Integer getAssetId() {
		return assetId;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	
}
