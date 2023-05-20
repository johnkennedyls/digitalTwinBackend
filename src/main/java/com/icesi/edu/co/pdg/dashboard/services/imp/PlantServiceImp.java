package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.PlantDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.repositories.PlantRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.PlantService;
import com.icesi.edu.co.pdg.dashboard.model.mappers.PlantMapper;

@Service
@Transactional
public class PlantServiceImp implements PlantService {

	@Autowired
	PlantRepository plantRepository;

	@Override
	public Plant AddPlant(PlantDTO plant) throws BadRequestDataException, IllegalArgumentException {
	  
	        if (plant.getPlantName() == null || plant.getPlantDescription() == null || plant.getConventions() == null) {
	            throw new BadRequestDataException();
	        } else {
	            if (plantRepository.existsByPlantName(plant.getPlantName().trim())) {
	                throw new IllegalArgumentException("El nombre de Planta ya esta en uso");
	            }else {

	           //PlantMapper plantMapper = Mappers.getMapper(PlantMapper.class);
	            PlantMapper  mapper = 	PlantMapper.INSTANCE;
	            Plant plantA = mapper.addplantDtoToPlant(plant);
	            Plant newplant = plantRepository.save(plantA);
	            return newplant;
	            }
	        }
	   
	}

	@Override
	public Plant modifyPlant(PlantDTO plant, Integer plantId) throws Exception {
		try {
			Plant existingPlant = plantRepository.findById(plantId)
					.orElseThrow(() -> new Exception("La planta no existe"));

			if (plant.getPlantName() == null || plant.getPlantDescription() == null || plant.getConventions() == null) {
				throw new BadRequestDataException();
			}

			if (!existingPlant.getPlantName().equals(plant.getPlantName())
					&& plantRepository.existsByPlantName(plant.getPlantName().trim())) {
				throw new IllegalArgumentException("El nombre de Planta ya está en uso");
			}else {

			existingPlant.setPlantName(plant.getPlantName());
			existingPlant.setPlantDescription(plant.getPlantDescription());
			existingPlant.setConventions(plant.getConventions());
			existingPlant.setPlantPhoto(plant.getPlantPhoto());

			return plantRepository.save(existingPlant);
			}
		} catch (NoSuchElementException e) {
			throw new Exception("La planta no existe");
		}
	}

	@Override

	public void deletePlant(Integer plantId) throws Exception {
		Optional<Plant> plantDelete = plantRepository.findById(plantId);
		try {

			if (plantDelete.isEmpty()) {
				throw new Exception("La planta no existe");
			}

			plantRepository.deleteById(plantId);
		} catch (Exception e) {
			throw new Exception("Error al eliminar la planta");
		}
	}

	@Override

	public List<Plant> getAllPlants() {
		return plantRepository.findAll();
	}

	@Override
	public Plant getbyIdPlant(Integer id) throws Exception {

		try {
			Plant plantSearch = plantRepository.findById(id).get();
			return plantSearch;
		} catch (Exception e) {
			throw new Exception("La planta no existe");
		}

	}

}
