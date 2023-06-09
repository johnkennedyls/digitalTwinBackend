package com.icesi.edu.co.pdg.dashboard.model.mappers.imp;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.mappers.PlantMapper;

public class PlantMapperImp implements PlantMapper{

	@Override
	public Plant plantInDTOToPlant(PlantInDTO plantDto) {
		Plant plant = new Plant();
		plant.setConventions(plantDto.getConventions());
		plant.setPlantDescription(plantDto.getPlantDescription());
		plant.setPlantName(plantDto.getPlantName());
		plant.setPlantPhoto(plantDto.getPlantPhoto());
		plant.setSvgImage(plantDto.getSvgImage());
	
		return plant;
	}

	@Override
	public PlantOutDTO plantToPlantOutDTO(Plant plant) {
		PlantOutDTO plantDto = new PlantOutDTO();
		plantDto.setConventions(plant.getConventions());
		plantDto.setPlantDescription(plant.getPlantDescription());
		plantDto.setPlantName(plant.getPlantName());
		plantDto.setPlantPhoto(plant.getPlantPhoto());
		plantDto.setSvgImage(plant.getSvgImage());
		
		return plantDto;
	}

	@Override
	public PlantListOutDTO plantToPlantListOutDTO(Plant plant) {
		PlantListOutDTO plantDto = new PlantListOutDTO();
		plantDto.setAssetId(plant.getAssetId());
		plantDto.setPlantDescription(plant.getPlantDescription());
		plantDto.setPlantId(plant.getPlantId());
		plantDto.setPlantName(plant.getPlantName());
		plantDto.setPlantPhoto(plant.getPlantPhoto());
		
		return plantDto;
	}

}
