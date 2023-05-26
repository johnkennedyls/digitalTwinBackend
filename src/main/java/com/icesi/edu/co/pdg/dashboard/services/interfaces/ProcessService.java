package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;
import icesi.plantapiloto.common.dtos.ProcessDTO;

public interface ProcessService {
	public ProcessDTO[] getAllProcess();
	public ProcessInDTO getProcess();
	public void addProcess(ProcessInDTO sd) throws BadRequestDataException;
	public void deleteProcess(Integer processId);
	
	public void startExecution(Integer processId) throws BadRequestDataException;
	public void pauseExecution(Integer executionId) throws BadRequestDataException;
	public void continueExecution(Integer executionId) throws BadRequestDataException;
	public void stopExecution(Integer executionId) throws BadRequestDataException;
	
}
