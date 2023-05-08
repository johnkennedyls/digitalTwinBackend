package com.icesi.edu.co.pdg.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.PlantDTO;

import com.icesi.edu.co.pdg.dashboard.services.interfaces.PlantService;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

@RestController
@CrossOrigin("*")
@RequestMapping("/plants")
public class PlantController {

	@Autowired
	private PlantService plantService;

	@PostMapping("/created")
	public ResponseEntity<Plant> addPlant(@RequestBody PlantDTO plantDTO) throws Exception {
		Plant plant;
		
		plant = plantService.AddPlant(plantDTO);
		return new ResponseEntity<>(plant, HttpStatus.CREATED);

	}

	@GetMapping("/")
	public ResponseEntity<List<Plant>> getAllPlants() {

		List<Plant> myPlant = new ArrayList<Plant>();

		myPlant = plantService.getAllPlants();
		return new ResponseEntity<>(myPlant, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Plant> getPlantById(@PathVariable Integer id) {
		try {
			Plant plant = plantService.getbyIdPlant(id);
			return ResponseEntity.ok(plant);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/modified/{id}")
	public ResponseEntity<Plant> modifyPlant(@RequestBody PlantDTO plant, @PathVariable Integer id) throws Exception {
		Plant modifiedPlant;
		try {

			modifiedPlant = plantService.modifyPlant(plant, id);
			return ResponseEntity.ok(modifiedPlant);

		} catch (BadRequestDataException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePlant(@PathVariable("id") Integer id) throws Exception {
		try {
			plantService.deletePlant(id);
			return ResponseEntity.ok("La planta con ID " + id + " ha sido eliminada exitosamente.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
