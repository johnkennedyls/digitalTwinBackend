package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import org.springframework.http.ResponseEntity;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;

public interface PlantController {
	public ResponseEntity<?> getAllPlants();
	public ResponseEntity<?> getPlantById(Integer plantId);
	public ResponseEntity<?> addPlant(PlantInDTO plantDto);
	public ResponseEntity<?> editPlant(PlantInDTO plantDto, Integer plantId);
	public ResponseEntity<?> deletePlant(Integer plantId);
}
