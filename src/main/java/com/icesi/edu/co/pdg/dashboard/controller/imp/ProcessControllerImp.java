package com.icesi.edu.co.pdg.dashboard.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.ProcessController;
import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.ProcessService;

import icesi.plantapiloto.common.dtos.ProcessDTO;

@RestController()
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
	@GetMapping("/{processId}")
	public ResponseEntity<?> getProcess(@PathVariable Integer processId) {
		// TODO Auto-generated method stub
		return null;
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
	public ResponseEntity<?> editProcess(@RequestBody ProcessInDTO processDto,@PathVariable Integer processId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> removeProcess(@PathVariable Integer processId) {
		// TODO Auto-generated method stub
		return null;
	}

}
