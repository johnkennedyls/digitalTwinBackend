package com.icesi.edu.co.pdg.dashboard.controller.imp;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
import com.icesi.edu.co.pdg.dashboard.model.dtos.SaamfiUserSpeOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.TypeAlarmService;
import com.icesi.edu.co.pdg.dashboard.services.springexpression.Context;

import icesi.plantapiloto.common.dtos.MeasurementDTO;

@RestController
@RequestMapping("/typeAlarms")
@CrossOrigin("Access-Control-Allow-Origin")
public class TypeAlarmControllerImp implements TypeAlarmController{
	
    private TypeAlarmService typeAlarmService;
    
    @Autowired
    public void setTypeAlarmService(TypeAlarmService typeAlarmService) {
		this.typeAlarmService = typeAlarmService;
	}

	@Override
	@GetMapping("/{typealarmid}")
	public ResponseEntity<TypeAlarmDetailOutDTO> getTypeAlarm(@PathVariable("typealarmid") Integer typealarmid) throws Exception {
		TypeAlarmDetailOutDTO alarm;
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
	public ResponseEntity<List<TypeAlarmListOutDTO>> getAllTypeAlarms() throws Exception {
		List<TypeAlarmListOutDTO> respOutDTO = new ArrayList<TypeAlarmListOutDTO>();
		respOutDTO = typeAlarmService.getAllTypeAlarms();
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/plant/{plantid}")
	public ResponseEntity<List<TypeAlarmListOutDTO>> getAllTypeAlarmsByPlant(@PathVariable("plantid") Integer plantid) throws Exception {
		List<TypeAlarmListOutDTO> respOutDTO = new ArrayList<TypeAlarmListOutDTO>();
		respOutDTO = typeAlarmService.getAllTypeAlarmsByPlantid(plantid);
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}

	@Override
	@PostMapping("/create")
	public ResponseEntity<?> addTypeAlarm(@RequestBody TypeAlarmDTO typealarm) throws Exception {
		TypeAlarmDTO alarm;
		try {
			alarm = typeAlarmService.addTypeAlarm(typealarm);
			return new ResponseEntity<>(alarm, HttpStatus.CREATED);
		}catch(BadRequestDataException e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@PutMapping("/edit/{typealarmid}")
	public ResponseEntity<?> editTypeAlarm(@PathVariable("typealarmid") Integer typealarmid, @RequestBody TypeAlarmDTO typealarm) throws Exception {
		TypeAlarmDTO alarm;
		try {
			alarm = typeAlarmService.editTypeAlarm(typealarmid,typealarm);
			return new ResponseEntity<>(alarm, HttpStatus.OK);
		}catch(BadRequestDataException e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
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

	@Override
	@GetMapping("/emails")
	public ResponseEntity<List<SaamfiUserSpeOutDTO>> getAllEmailUsers() throws Exception {
		List<SaamfiUserSpeOutDTO> respOutDTO = new ArrayList<SaamfiUserSpeOutDTO>();
		respOutDTO = typeAlarmService.getAllEmailUsers();
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}

}
