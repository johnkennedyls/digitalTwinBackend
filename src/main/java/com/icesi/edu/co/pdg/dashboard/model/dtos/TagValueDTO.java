package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class TagValueDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3608453430956948918L;
	
	private int assetId;
	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getExtId() {
		return extId;
	}

	public void setExtId(int extId) {
		this.extId = extId;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	private String assetName;
	private double value;
	private int extId;
	private long timeStamp;
	
	public static List<TagValueDTO> getTagValueDummy() {
		List<TagValueDTO> tags = new ArrayList<>();
		
		AssetDTO[] plantState = AssetDTO.getAssetListDummy();
		for(AssetDTO currentPlant : plantState) {
			for(AssetDTO currentTag : currentPlant.childrens) {
				TagValueDTO tag = new TagValueDTO();
				tag.setAssetId(currentTag.assetId);
				tag.setAssetName(currentTag.name);
				tag.setValue(Math.random()*100);
				tag.setExtId(0);
				tag.setTimeStamp(Timestamp.valueOf(LocalDateTime.now()).getTime()); 
				tags.add(tag);
			}
		}
		
		return tags;
	}
}
