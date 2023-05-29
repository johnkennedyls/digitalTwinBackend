package com.icesi.edu.co.pdg.dashboard.controller.imp;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.ProcessController;
import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.UnexpectedException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.ProcessService;

import icesi.plantapiloto.common.dtos.ProcessDTO;

@RestController()
@CrossOrigin("*")
@RequestMapping("/processes")
public class ProcessControllerImp implements ProcessController {
	
	@Autowired
	ProcessService processService;
	
	@Override
	@GetMapping("")
	public ResponseEntity<?> getAllProcess() {
		ProcessDTO[] processes =  processService.getAllProcess();
		return ResponseEntity.ok(processes);
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<?> addProcess(@RequestBody ProcessInDTO processDto) {
		try {
			processService.addProcess(processDto);
		} catch (BadRequestDataException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok("Agregado correctamente");
	}

	@Override
	@PostMapping("/start/{processId}")
	public ResponseEntity<?> startProcess(@PathVariable Integer processId) {
		try {
			processService.startExecution(processId);
		} catch (BadRequestDataException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch(UnexpectedException e) {
//			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("Proceso inciado correctamente");
	}

	@Override
	@PostMapping("/pause/{processId}")
	public ResponseEntity<?> pauseProcess(@PathVariable Integer processId) {
		try {
			processService.pauseExecution(processId);
		} catch (BadRequestDataException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch (MqttException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("Proceso pausado correctamente");
	}

	@Override
	@PostMapping("/stop/{processId}")
	public ResponseEntity<?> stopProcess(@PathVariable Integer processId) {
		try {
			System.out.println("sd");
			processService.stopExecution(processId);
		} catch (BadRequestDataException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch (MqttException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("Proceso detenido correctamente");
	}

}
