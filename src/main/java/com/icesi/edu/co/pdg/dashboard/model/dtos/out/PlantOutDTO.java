package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.MapSvgTagDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagDTO;

public class PlantOutDTO {
	private String plantName; 
	private String plantDescription;
	private String conventions;
	private String plantPhoto;
	private String svgImage;
	private String plantIp;
	private String plantSlot;
	private List<TagDTO> tags;
	private List<MapSvgTagDTO> mapSvgTag;
	
	public String getPlantDescription() {
		return plantDescription;
	}
	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}
	public String getConventions() {
		return conventions;
	}
	public void setConventions(String conventions) {
		this.conventions = conventions;
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
	public String getSvgImage() {
		return svgImage;
	}
	public void setSvgImage(String svgImage) {
		this.svgImage = svgImage;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public List<MapSvgTagDTO> getMapSvgTag() {
		return mapSvgTag;
	}
	public void setMapSvgTag(List<MapSvgTagDTO> mapSvgTag) {
		this.mapSvgTag = mapSvgTag;
	}
	public String getPlantIp() {
		return plantIp;
	}
	public void setPlantIp(String plantIp) {
		this.plantIp = plantIp;
	}
	public String getPlantSlot() {
		return plantSlot;
	}
	public void setPlantSlot(String plantSlot) {
		this.plantSlot = plantSlot;
	}
}
