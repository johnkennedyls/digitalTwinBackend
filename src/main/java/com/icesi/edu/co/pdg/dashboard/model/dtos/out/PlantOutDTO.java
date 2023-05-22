package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.TagDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.MapSvgTag;

public class PlantOutDTO {
	private String plantName; 
	private String plantDescription;
	private String conventions;
	private String plantPhoto;
	private List<TagDTO> tags;
	private String svgImage;
	private List<MapSvgTag> svgs;
	
	
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
	public List<MapSvgTag> getSvgs() {
		return svgs;
	}
	public void setSvgs(List<MapSvgTag> svgs) {
		this.svgs = svgs;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
}
