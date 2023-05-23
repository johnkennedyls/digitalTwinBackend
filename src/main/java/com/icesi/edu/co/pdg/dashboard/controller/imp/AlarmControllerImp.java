package com.icesi.edu.co.pdg.dashboard.controller.imp;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.edu.co.pdg.dashboard.controller.interfaces.AlarmController;
import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.AlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AlarmService;

@RestController
@CrossOrigin("*")
@RequestMapping("/alarms")
public class AlarmControllerImp implements AlarmController {
	
	@Autowired
    private AlarmService alarmService;

	@Override
	@GetMapping("/")
	public ResponseEntity<List<AlarmListOutDTO>> getAllAlarmsGenerate() throws Exception {
		List<AlarmListOutDTO> respOutDTO = new ArrayList<AlarmListOutDTO>();
		respOutDTO = alarmService.getAllAlarms();
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}
	@Override
	@GetMapping("/history")
	public ResponseEntity<List<AlarmListOutDTO>> getAllAlarmsClosed() throws Exception {
		List<AlarmListOutDTO> respOutDTO = new ArrayList<AlarmListOutDTO>();
		respOutDTO = alarmService.getAllAlarmsClosed();
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}
	@Override
	@GetMapping("/active")
	public ResponseEntity<List<AlarmListOutDTO>> getAllAlarmsActive() throws Exception {
		List<AlarmListOutDTO> respOutDTO = new ArrayList<AlarmListOutDTO>();
		respOutDTO = alarmService.getAllAlarmsActive();
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}
	@Override
	@GetMapping("/history/{plantid}")
	public ResponseEntity<List<AlarmListOutDTO>> getAllAlarmsClosedByPlantId(@PathVariable("plantid") Integer plantid) throws Exception {
		List<AlarmListOutDTO> respOutDTO = new ArrayList<AlarmListOutDTO>();
		respOutDTO = alarmService.getAllAlarmsClosedByPlantId(plantid);
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}
	@Override
	@GetMapping("/active/{plantid}")
	public ResponseEntity<List<AlarmListOutDTO>> getAllAlarmsActiveByPlantId(@PathVariable("plantid") Integer plantid) throws Exception {
		List<AlarmListOutDTO> respOutDTO = new ArrayList<AlarmListOutDTO>();
		respOutDTO = alarmService.getAllAlarmsActiveByPlantId(plantid);
		return new ResponseEntity<>(respOutDTO, HttpStatus.OK);
	}
	@Override
	@GetMapping("/{alarmid}")
	public ResponseEntity<AlarmDetailOutDTO> getAlarmById(@PathVariable("alarmid") Integer alarmid) throws Exception {
		AlarmDetailOutDTO alarm;
		try {
			alarm = alarmService.getAlarm(alarmid);
			return new ResponseEntity<>(alarm, HttpStatus.OK);
		}catch(BadRequestDataException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch(NoResultException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
