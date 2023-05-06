package com.icesi.edu.co.pdg.dashboard.model.dtos;

import java.io.Serializable;

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
	private String assetName;
	private double value;
	private long timeStamp;
}
