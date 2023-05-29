package com.icesi.edu.co.pdg.dashboard.services.imp;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.UnexpectedException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;
import com.icesi.edu.co.pdg.dashboard.services.connection.MqttManager;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.ProcessService;

import icesi.plantapiloto.common.controllers.ProcessManagerControllerPrx;
import icesi.plantapiloto.common.dtos.ExecutionDTO;
import icesi.plantapiloto.common.dtos.ProcessDTO;


@Service
public class ProcessServiceImp implements ProcessService{
	
	@Autowired
	private ProcessManagerControllerPrx processManager;
	@Autowired
	private MqttManager mqttManager;
	
	@Value("${webdasboard.workspace.id}")
	private Integer workspaceId;
	
	@Override
	public ProcessDTO[] getAllProcess() {
		ProcessDTO[] processList = processManager.findProcessByWorkSpace(workspaceId);
		return processList;
	}
	
	@Override
	public void addProcess(ProcessInDTO sd) throws BadRequestDataException {
		if(sd == null) {
			throw new BadRequestDataException();
		}
		if(
			sd.getProcessName()==null || sd.getProcessName().isEmpty() ||
			sd.getProcessDescription() == null || sd.getProcessDescription().isEmpty() ||
			sd.getSelectedAssets()==null || sd.getSelectedAssets().length == 0
		){
			throw new BadRequestDataException();
		}
		int processId = processManager.saveProcess(sd.getProcessName(), sd.getProcessDescription(), workspaceId);
		if(processId==-1) {
			throw new RuntimeException("Error interno, intente más tarde");
		}
		for(Integer assetId : sd.getSelectedAssets()) {
			processManager.addAssetToProcess(assetId, processId, 10000);
		}
	}
	
	@Override
	public void startExecution(Integer processId) throws BadRequestDataException, UnexpectedException{
		if(processId==null) {
			throw new BadRequestDataException();
		}
		ExecutionDTO[] currentExecutions = processManager.findExecutions(processId, 0, 0, true);
		if(currentExecutions.length>0) {
			return;
		}
		Integer executionId = processManager.startProcess(processId, "Usuario de prueba");
		try {
			mqttManager.subscribeToMqtt(executionId+"");
		} catch (Exception e) {
			throw new UnexpectedException();
		}
	}

	@Override
	public void pauseExecution(Integer processId) throws BadRequestDataException, MqttException {
		
		ExecutionDTO[] currentExecutions = processManager.findExecutions(processId, 0, 0, true);
		if(currentExecutions.length<=0) {
			throw new BadRequestDataException();
		}
		int executionId = currentExecutions[0].id;
		
		processManager.pauseExecutionProcess(executionId);
		mqttManager.unsubscribeOfMqtt(executionId+"");
	}

	@Override
	public void continueExecution(Integer processId) throws BadRequestDataException, UnexpectedException{
		
		ExecutionDTO[] currentExecutions = processManager.findExecutions(processId, 0, 0, true);
		if(currentExecutions.length<=0) {
			throw new BadRequestDataException();
		}
		int executionId = currentExecutions[0].id;
		processManager.continueExecutionProcess(executionId);
		try {
			mqttManager.subscribeToMqtt(executionId+"");
		} catch (Exception e) {
			throw new UnexpectedException();
		}
	}

	@Override
	public void stopExecution(Integer processId) throws BadRequestDataException, MqttException {
		ExecutionDTO[] currentExecutions = processManager.findExecutions(processId, 0, 0, true);
		if(currentExecutions.length<=0) {
			throw new BadRequestDataException();
		}
		int executionId = currentExecutions[0].id;
		
		processManager.stopExecutionProcess(executionId);
		mqttManager.unsubscribeOfMqtt(executionId+"");
	}
	
}
