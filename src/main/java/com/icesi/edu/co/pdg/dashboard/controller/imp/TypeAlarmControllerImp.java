package com.icesi.edu.co.pdg.dashboard.controller.imp;

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

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.TypeAlarmController;
import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.TypeAlarmService;

@CrossOrigin("*")
@RequestMapping("/typeAlarms")
@RestController
public class TypeAlarmControllerImp implements TypeAlarmController{
	
	@Autowired
    private TypeAlarmService typeAlarmService;

	@Override
	@GetMapping("/{typealarmid}")
	public ResponseEntity<TypeAlarmDTO> getTypeAlarm(@PathVariable("typealarmid") Integer typealarmid) throws Exception {
		TypeAlarmDTO alarm;
		try {
			alarm = typeAlarmService.getTypeAlarm(typealarmid);
			return new ResponseEntity<>(alarm, HttpStatus.OK);
		}catch(BadRequestDataException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@GetMapping("/")
	public ResponseEntity<List<TypeAlarmDTO>> getAllTypeAlarms() throws Exception {
		List<TypeAlarmDTO> respOutDTO = new ArrayList<TypeAlarmDTO>();
		try {
			respOutDTO = typeAlarmService.getAllTypeAlarms();
			return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@PostMapping("/create")
	public ResponseEntity<TypeAlarm> addTypeAlarm(@RequestBody TypeAlarmDTO typealarm) throws Exception {
		TypeAlarm alarm;
		try {
			alarm = typeAlarmService.addTypeAlarm(typealarm);
			return new ResponseEntity<>(alarm, HttpStatus.CREATED);
		}catch(BadRequestDataException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@PutMapping("/edit/{typealarmid}")
	public ResponseEntity<TypeAlarm> editTypeAlarm(@PathVariable("typealarmid") Integer typealarmid, @RequestBody TypeAlarmDTO typealarm) throws Exception {
		TypeAlarm alarm;
		try {
			alarm = typeAlarmService.editTypeAlarm(typealarmid,typealarm);
			return new ResponseEntity<>(alarm, HttpStatus.OK);
		}catch(BadRequestDataException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@DeleteMapping("/delete/{typealarmid}")
	public ResponseEntity<String> deleteTypeAlarm(@PathVariable("typealarmid") Integer typealarmid) throws Exception {
		TypeAlarm alarm;
		try {
			alarm = typeAlarmService.deleteTypeAlarm(typealarmid);
			return new ResponseEntity<>("Fue eliminado correctamente", HttpStatus.OK);
		}catch(BadRequestDataException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
