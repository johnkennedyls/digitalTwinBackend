package com.icesi.edu.co.pdg.dashboard.controller.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.PlantController;
import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantOutDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.PlantService;

import icesi.plantapiloto.common.dtos.MeasurementDTO;

@RestController()
@RequestMapping("/plants")
@CrossOrigin("Access-Control-Allow-Origin")
public class PlantControllerImp implements PlantController {
	
	@Autowired
	private PlantService service;

	@Override
	@GetMapping("")
	public ResponseEntity<?> getAllPlants() {
		System.out.println("ASDOASUJDH");
		List<PlantListOutDTO> plants = service.getAllPlants();
		return ResponseEntity.ok(plants);
	}

	@Override
	@GetMapping("/{plantId}")
	public ResponseEntity<?> getPlantById(@PathVariable Integer plantId) {
		PlantOutDTO plant = null;
		try {
			plant = service.getPlantById(plantId);
		} catch (NoResultException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.ok(plant);
	}
	
	@Override
	@PostMapping("/add")
	public ResponseEntity<?> addPlant(@RequestBody PlantInDTO plantDTO)  {
		try {
			System.out.println(plantDTO.toString());
			service.addPlant(plantDTO);
		} catch (BadRequestDataException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.ok("Agregado correctamente");
	}

	@Override
	@PutMapping("/edit/{plantId}")
	public ResponseEntity<?> editPlant(@RequestBody PlantInDTO plantDto,@PathVariable Integer plantId) {
		try {
			service.editPlant(plantDto, plantId);
		} catch (BadRequestDataException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok("Editado correctamente");
	}


	@Override
	@DeleteMapping("/delete/{plantId}")
	public ResponseEntity<?> deletePlant(@PathVariable Integer plantId) {
		try {
			service.deletePlant(plantId);
		} catch (BadRequestDataException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok("Eliminado correctamente");
	}

	@Override
	@GetMapping("/delimited/{plantId}/{startDate}/{endDate}")
	public ResponseEntity<?> getDelimitatedData(@PathVariable Integer plantId, @PathVariable Long startDate, @PathVariable Long endDate) {
		List<MeasurementDTO> measures = null;
		try {
			measures = service.getTagValuesByStartAndEndDate(plantId, startDate, endDate);
		} catch (BadRequestDataException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(measures, HttpStatus.OK ) ;
	}
}
