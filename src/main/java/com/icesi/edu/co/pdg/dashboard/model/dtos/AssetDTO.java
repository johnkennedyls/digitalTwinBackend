package com.icesi.edu.co.pdg.dashboard.model.dtos;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssetDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3361938168837063630L;
	
	public int assetId;
    public String name;
    public String typeName;
    public String state;
    public AssetDTO[] childrens;
}

