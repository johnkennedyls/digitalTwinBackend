package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.UnexpectedException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;

import icesi.plantapiloto.common.dtos.ExecutionDTO;
import icesi.plantapiloto.common.dtos.ProcessDTO;

public interface ProcessService {
	public ProcessDTO[] getAllProcess();
	public void addProcess(ProcessInDTO process) throws BadRequestDataException;
	public void editProcess(ProcessInDTO process, Integer processId) throws BadRequestDataException;
	public void deleteProcess(Integer processId) throws BadRequestDataException, UnexpectedException;
	
	public ExecutionDTO[] getExecutionByProcess(Integer processId) throws BadRequestDataException, UnexpectedException;
	public void startExecution(Integer processId) throws BadRequestDataException, UnexpectedException;
	public void pauseExecution(Integer processId) throws BadRequestDataException, MqttException;
	public void continueExecution(Integer processId) throws BadRequestDataException, UnexpectedException;
	public void stopExecution(Integer processId) throws BadRequestDataException, MqttException;
	
}
