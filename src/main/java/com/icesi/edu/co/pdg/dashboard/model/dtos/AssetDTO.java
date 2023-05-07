package com.icesi.edu.co.pdg.dashboard.model.dtos;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    
    public static AssetDTO[] getAssetListDummy() {
    	 AssetDTO s1BR40L = new AssetDTO(2, "Temperatura", "TAG", "activo", null);
         AssetDTO s2BR40L = new AssetDTO(3, "Presión", "TAG", "activo", null);
         AssetDTO s3BR40L = new AssetDTO(4, "Volumen de líquido", "TAG", "activo", null);

         AssetDTO[] bioreactor40LSensors = { s1BR40L, s2BR40L, s3BR40L };

         AssetDTO bioreactor40L = new AssetDTO(1, "Bioreactor 40L", "PLC", "activo", bioreactor40LSensors);
         
         // Bioreactor 80L
         AssetDTO s1BR80L = new AssetDTO(12, "Temperatura", "TAG", "activo", null);
         AssetDTO s2BR80L = new AssetDTO(13, "pH", "TAG", "activo", null);
         AssetDTO s3BR80L = new AssetDTO(14, "Nivel de Oxigeno", "TAG", "activo", null);
         
         AssetDTO[] bioreactor80LSensors = { s1BR80L, s2BR80L, s3BR80L };
         
         AssetDTO bioreactor80L = new AssetDTO(11, "Bioreactor 80L", "PLC", "activo", bioreactor80LSensors);
         
         // Bioreactor 120L
         AssetDTO s1BR120L = new AssetDTO(22, "Temperatura", "TAG", "activo", null);
         AssetDTO s2BR120L = new AssetDTO(23, "Presión", "TAG", "activo", null);
         AssetDTO s3BR120L = new AssetDTO(24, "pH", "TAG", "activo", null);
         
         AssetDTO[] bioreactor120LSensors = { s1BR120L, s2BR120L, s3BR120L };
         
         AssetDTO bioreactor120L = new AssetDTO(21, "Bioreactor 120L", "PLC", "activo", bioreactor120LSensors);
         
         AssetDTO[] plants = {bioreactor40L,bioreactor80L,bioreactor120L};
         
         return plants;
    }
}

