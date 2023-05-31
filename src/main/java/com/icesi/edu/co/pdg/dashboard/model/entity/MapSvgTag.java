package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
/**
 * The persistent class for the svg database table.
 * 
 */
@Entity
public class MapSvgTag implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="map_svg_id")
	@SequenceGenerator(name = "DASHBOARD_MAP_SVG_ID_GENERATOR", sequenceName = "dashboard_map_svg_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DASHBOARD_MAP_SVG_ID_GENERATOR")
	private Integer mapSvgId;
	
	@Column(name="id_svg")
	private String idSvg;

	@Column(name="id_asset")
	private Integer idAsset;
	
	@Column(name="tag_name")
	private String tagName;

	@ManyToOne
	@JoinColumn(name="plant_id")
	private Plant plant;

	public MapSvgTag() {
	}
	
	public String getIdSvg() {
		return idSvg;
	}
	
	public void setIdSvg(String idSvg) {
		this.idSvg = idSvg;
	}
	
	public Integer getIdAsset() {
		return this.idAsset;
	}

	public void setIdAsset(Integer idAsset) {
		this.idAsset = idAsset;
	}

	public Plant getPlant() {
		return this.plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}