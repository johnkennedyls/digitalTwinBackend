package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the svg database table.
 * 
 */
@Entity
@NamedQuery(name="Svg.findAll", query="SELECT s FROM Svg s")
public class Svg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_svg")
	private Integer idSvg;

	@Column(name="id_asset")
	private Integer idAsset;

	//bi-directional many-to-one association to Plant
	@ManyToOne
	@JoinColumn(name="plant_id")
	private Plant plant;

	public Svg() {
	}

	public Integer getIdSvg() {
		return this.idSvg;
	}

	public void setIdSvg(Integer idSvg) {
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

}