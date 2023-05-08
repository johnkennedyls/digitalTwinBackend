package com.icesi.edu.co.pdg.dashboard.model.mappers.interfaces;

import org.mapstruct.factory.Mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.PlantDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

public interface PlantMapper {

 Plant INSTANCE =Mappers.getMapper(Plant.class);

	Plant addPlantDto(PlantDTO plantDTO);

}
