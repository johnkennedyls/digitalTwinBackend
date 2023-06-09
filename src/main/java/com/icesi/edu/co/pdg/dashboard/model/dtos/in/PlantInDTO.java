package com.icesi.edu.co.pdg.dashboard.model.dtos.in;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.MapSvgTagDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagDTO;


public class PlantInDTO {
	private String plantName; 
	private String plantDescription;
	private String conventions;
	private String plantPhoto;
	private String plantIp;
	private String plantSlot;
	private List<TagDTO> tags;
	private String svgImage;
	private List<MapSvgTagDTO> mapSvgTag;
	
	public String getConventions() {
		return conventions;
	}
	public void setConventions(String conventions) {
		this.conventions = conventions;
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
	
	@Override
	public String toString() {
		return "PlantInDTO [plantName=" + plantName + ", plantDescription=" + plantDescription + ", conventions="
				+ conventions + ", plantPhoto=Dummy" + ", tags=" + tags
				+ ", mapSvgTag=" + mapSvgTag + "]";
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
