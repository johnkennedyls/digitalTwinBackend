package com.icesi.edu.co.pdg.dashboard.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.PlantController;
import com.icesi.edu.co.pdg.dashboard.model.dtos.AssetDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.PlantService;

@RestController()
@RequestMapping("/dashboardapi/plants")
@CrossOrigin("*")
public class PlantControllerImp implements PlantController {
	
	@Autowired
	private PlantService service;

	@Override
	@GetMapping("")
	public ResponseEntity<?> getAllPlants() {
		List<AssetDTO> plants = service.getAllPlantData();
		return ResponseEntity.ok(plants);
	}

}
