package com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.PlantDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

@Mapper
public interface PlantMapper {

	PlantMapper INSTANCE = Mappers.getMapper(PlantMapper.class);
	public PlantDTO plantToPlantDto(Plant plant);
	public Plant addplantDtoToPlant(PlantDTO plantDto);




	
}
