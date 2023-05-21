package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;


import java.util.List;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the plant database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Plant.findAll", query="SELECT p FROM Plant p")
public class Plant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="plant_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer plantId;

	private String conventions;

	@Column(name="id_asset")
	private Integer idAsset;

	@Column(name="plant_description")
	private String plantDescription;

	@Column(name="plant_name")
	private String plantName;

	@Column(name="plant_photo")
	private String plantPhoto;
	
	private String svgImage;

	//bi-directional many-to-one association to Svg
	@OneToMany(mappedBy="plant")
	private List<Svg> svgs;

	//bi-directional many-to-one association to TypeAlarm
	@OneToMany(mappedBy="plant")
	private List<TypeAlarm> typeAlarms;

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