package com.icesi.edu.co.pdg.dashboard.model.dtos;

public class MapSvgTagDTO {
	private String svgId;
	private Integer idAsset;
	private String tagName;
	
	public String getSvgId() {
		return svgId;
	}
	public void setSvgId(String svgId) {
		this.svgId = svgId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Integer getIdAsset() {
		return idAsset;
	}
	public void setIdAsset(Integer idAsset) {
		this.idAsset = idAsset;
	}
}
