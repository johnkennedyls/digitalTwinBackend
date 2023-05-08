package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.entity.Svg;

public class PlantDTO {

	


	private String plantName; 
	
	private String conventions;

	private String plantDescription;
	
	private byte[] plantPhoto;
	
	private List<Svg> svgs;


	

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

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

	public byte[] getPlantPhoto() {
		return plantPhoto;
	}

	public void setPlantPhoto(byte[] plantPhoto) {
		this.plantPhoto = plantPhoto;
	}

	public List<Svg> getSvgs() {
		return svgs;
	}

	public void setSvgs(List<Svg> svgs) {
		this.svgs = svgs;
	}
	
	
	
}
