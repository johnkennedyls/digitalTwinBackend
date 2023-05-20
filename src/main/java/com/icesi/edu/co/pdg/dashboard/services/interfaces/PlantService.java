package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.PlantDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

public interface PlantService {
	List<Plant> getAllPlants();
	Plant getbyIdPlant(Integer id) throws Exception;
	
	Plant AddPlant(PlantDTO plant) throws BadRequestDataException, IllegalArgumentException;
	Plant modifyPlant(PlantDTO plant, Integer plantId) throws Exception;
	void deletePlant(Integer plantId) throws Exception;
}
