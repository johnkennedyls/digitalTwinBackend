package com.icesi.edu.co.pdg.dashboard.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

@Mapper
public interface PlantMapper {
	PlantMapper INSTANCE = Mappers.getMapper(PlantMapper.class);
	
	public Plant plantInDTOToPlant(PlantInDTO plantDto);
	public PlantOutDTO plantToPlantOutDTO(Plant plant);
	public PlantListOutDTO plantToPlantListOutDTO(Plant plant);
}
