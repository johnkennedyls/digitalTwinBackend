package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import icesi.plantapiloto.common.dtos.MeasurementDTO;

public class MeasureListOutDTO {
	private Integer assetId;
	private MeasurementDTO[] measures;
	
	public Integer getAssetId() {
		return assetId;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	public MeasurementDTO[] getMeasures() {
		return measures;
	}
	public void setMeasures(MeasurementDTO[] measures) {
		this.measures = measures;
	}
}
