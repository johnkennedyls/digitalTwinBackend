package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import java.util.Base64;
import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.dtos.PlantDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.Svg;
import com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces.PlantMapper;

public class PlantMapperImpl  implements PlantMapper{
	
	@Override
	public Plant addPlantDto(PlantDTO plantDTO) {
		
		
		if(plantDTO== null) {
			return null;
		}
		Plant  plant = new Plant();
		
		plant.setPlantName(plantDTO.getPlantName());
        plant.setPlantDescription(plantDTO.getPlantDescription());
        plant.setConventions(plantDTO.getConventions());
        plant.setSvgs(plantDTO.getSvgs());
        
        byte[] decodedImage = Base64.getDecoder().decode(plantDTO.getPlantPhoto());
        plant.setPlantPhoto(decodedImage);
        

        
        
     return plant;
    	
	}

}
