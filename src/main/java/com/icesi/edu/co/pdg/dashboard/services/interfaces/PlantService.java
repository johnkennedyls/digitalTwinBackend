package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import java.util.List;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.MeasureListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantOutDTO;

import icesi.plantapiloto.common.dtos.MeasurementDTO;

public interface PlantService {
	List<PlantListOutDTO> getAllPlants();
	PlantOutDTO getPlantById(Integer id) throws NoResultException;
	void addPlant(PlantInDTO plant) throws BadRequestDataException;
	void editPlant(PlantInDTO plant, Integer plantId) throws BadRequestDataException ;
	void deletePlant(Integer plantId) throws BadRequestDataException;
	List<MeasureListOutDTO> getTagValuesByStartAndEndDate(Integer plantId, Long startDate, Long endDate) throws BadRequestDataException;
}
