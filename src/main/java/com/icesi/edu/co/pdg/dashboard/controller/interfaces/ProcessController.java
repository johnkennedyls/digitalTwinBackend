package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import org.springframework.http.ResponseEntity;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;

public interface ProcessController {
	public ResponseEntity<?> getAllProcess();
	public ResponseEntity<?> getProcess(Integer processId);
	public ResponseEntity<?> addProcess(ProcessInDTO processDto);
	public ResponseEntity<?> editProcess(ProcessInDTO processDto, Integer processId);
	public ResponseEntity<?> removeProcess(Integer processId);
}
