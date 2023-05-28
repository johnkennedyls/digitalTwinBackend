package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.UnexpectedException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;
import icesi.plantapiloto.common.dtos.ProcessDTO;

public interface ProcessService {
	public ProcessDTO[] getAllProcess();
	public ProcessInDTO getProcess();
	public void addProcess(ProcessInDTO sd) throws BadRequestDataException;
	
	public void startExecution(Integer processId) throws BadRequestDataException, UnexpectedException;
	public void pauseExecution(Integer executionId) throws BadRequestDataException, MqttException;
	public void continueExecution(Integer executionId) throws BadRequestDataException, UnexpectedException;
	public void stopExecution(Integer executionId) throws BadRequestDataException, MqttException;
	
}
