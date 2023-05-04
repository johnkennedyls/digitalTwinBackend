package com.icesi.edu.co.pdg.dashboard.model.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dashboard_value database table.
 * 
 */
@Entity
@Table(name="dashboard_value")
@NamedQuery(name="DashboardValue.findAll", query="SELECT d FROM DashboardValue d")
public class DashboardValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="value_id")
	private Integer valueId;

	@Column(name="graphic_id")
	private Integer graphicId;

	@Column(name="svg_id")
	private byte[] svgId;

	@Column(name="tag_name")
	private String tagName;

	//bi-directional many-to-one association to TypeAlarm
	@OneToMany(mappedBy="dashboardValue")
	private List<TypeAlarm> typeAlarms;

	public DashboardValue() {
	}

	public Integer getValueId() {
		return this.valueId;
	}

	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}

	public Integer getGraphicId() {
		return this.graphicId;
	}

	public void setGraphicId(Integer graphicId) {
		this.graphicId = graphicId;
	}

	public byte[] getSvgId() {
		return this.svgId;
	}

	public void setSvgId(byte[] svgId) {
		this.svgId = svgId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<TypeAlarm> getTypeAlarms() {
		return this.typeAlarms;
	}

	public void setTypeAlarms(List<TypeAlarm> typeAlarms) {
		this.typeAlarms = typeAlarms;
	}

	public TypeAlarm addTypeAlarm(TypeAlarm typeAlarm) {
		getTypeAlarms().add(typeAlarm);
		typeAlarm.setDashboardValue(this);

		return typeAlarm;
	}

	public TypeAlarm removeTypeAlarm(TypeAlarm typeAlarm) {
		getTypeAlarms().remove(typeAlarm);
		typeAlarm.setDashboardValue(null);

		return typeAlarm;
	}

}