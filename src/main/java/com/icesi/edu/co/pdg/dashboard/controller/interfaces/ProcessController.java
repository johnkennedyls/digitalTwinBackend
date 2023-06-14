package com.icesi.edu.co.pdg.dashboard.controller.interfaces;

import org.springframework.http.ResponseEntity;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;

public interface ProcessController {
	public ResponseEntity<?> getAllProcess();
	public ResponseEntity<?> getExecutionsByProcess(Integer processId);
	public ResponseEntity<?> addProcess(ProcessInDTO processDto);
	public ResponseEntity<?> startProcess(Integer processId);
	public ResponseEntity<?> pauseProcess(Integer processId);
	public ResponseEntity<?> stopProcess(Integer processId);
}
