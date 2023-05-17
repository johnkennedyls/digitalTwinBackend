package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

/**
 * The persistent class for the plant database table.
 * 
 */
@Entity
@NamedQuery(name="Plant.findAll", query="SELECT p FROM Plant p")
public class Plant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="plant_id")
	private Integer plantId;

	private String conventions;

	@Column(name="id_asset")
	private Integer idAsset;

	@Column(name="plant_description")
	private String plantDescription;

	@Column(name="plant_name")
	private String plantName;

	@Column(name="plant_photo")
	private byte[] plantPhoto;

	//bi-directional many-to-one association to Svg
	@OneToMany(mappedBy="plant")
	private List<Svg> svgs;

	//bi-directional many-to-one association to TypeAlarm
	@OneToMany(mappedBy="plant")
	private List<TypeAlarm> typeAlarms;

	public Plant() {
	}

	public Integer getPlantId() {
		return this.plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public String getConventions() {
		return this.conventions;
	}

	public void setConventions(String conventions) {
		this.conventions = conventions;
	}

	public Integer getIdAsset() {
		return this.idAsset;
	}

	public void setIdAsset(Integer idAsset) {
		this.idAsset = idAsset;
	}

	public String getPlantDescription() {
		return this.plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public String getPlantName() {
		return this.plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public byte[] getPlantPhoto() {
		return this.plantPhoto;
	}

	public void setPlantPhoto(byte[] plantPhoto) {
		this.plantPhoto = plantPhoto;
	}

	public List<Svg> getSvgs() {
		return this.svgs;
	}

	public void setSvgs(List<Svg> svgs) {
		this.svgs = svgs;
	}

	public Svg addSvg(Svg svg) {
		getSvgs().add(svg);
		svg.setPlant(this);

		return svg;
	}

	public Svg removeSvg(Svg svg) {
		getSvgs().remove(svg);
		svg.setPlant(null);

		return svg;
	}

	public List<TypeAlarm> getTypeAlarms() {
		return this.typeAlarms;
	}

	public void setTypeAlarms(List<TypeAlarm> typeAlarms) {
		this.typeAlarms = typeAlarms;
	}

	public TypeAlarm addTypeAlarm(TypeAlarm typeAlarm) {
		getTypeAlarms().add(typeAlarm);
		typeAlarm.setPlant(this);

		return typeAlarm;
	}

	public TypeAlarm removeTypeAlarm(TypeAlarm typeAlarm) {
		getTypeAlarms().remove(typeAlarm);
		typeAlarm.setPlant(null);

		return typeAlarm;
	}

}