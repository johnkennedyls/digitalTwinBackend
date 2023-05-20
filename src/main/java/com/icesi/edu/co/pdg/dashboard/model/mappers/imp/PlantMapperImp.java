package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;




import com.icesi.edu.co.pdg.dashboard.model.dtos.PlantDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

import com.icesi.edu.co.pdg.dashboard.model.mappers.PlantMapper;

public class PlantMapperImp  implements PlantMapper{
	
	
	@Override
	public PlantDTO plantToPlantDto(Plant plant) {
		if (plant == null) {
			return null;
		}
		
		PlantDTO plantDto = new PlantDTO();
		
		plantDto.setConventions(plant.getConventions());
		plantDto.setPlantDescription(plant.getPlantDescription());
		plantDto.setPlantName(plant.getPlantName());
		plantDto.setPlantPhoto(plant.getPlantPhoto());
		plantDto.setSvgs(plant.getSvgs());
	
		
		return plantDto;
	}
	
	@Override
	public Plant addplantDtoToPlant(PlantDTO plantDto) {
		if (plantDto == null) {
			return null;
		}
		
		Plant plant = new Plant();
		
		plant.setConventions(plantDto.getConventions());
		plant.setPlantDescription(plantDto.getPlantDescription());
		plant.setPlantName(plantDto.getPlantName());
		plant.setPlantPhoto(plantDto.getPlantPhoto());
		plant.setSvgs(plantDto.getSvgs());
		
		return plant;
	}
	
}
