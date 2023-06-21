package com.icesi.edu.co.pdg.dashboard.services.imp;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.UnexpectedException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.ProcessListOutDTO;
import com.icesi.edu.co.pdg.dashboard.services.connection.MqttManager;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.ProcessService;

import co.edu.icesi.dev.saamfi.saamfisecurity.delegate.SaamfiDelegate;
import icesi.plantapiloto.common.consts.ExecutionState;
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
	@Value("${saamfi.api.url}")
	private String saamfiUrl;
	
	@Override
	public ProcessListOutDTO[] getAllProcess() {
		ProcessDTO[] processList = processManager.findProcessByWorkSpace(workspaceId);
		ProcessListOutDTO[] list = new ProcessListOutDTO[processList.length];
		for(int i = 0; i < processList.length;i++) {
			list[i] = new ProcessListOutDTO();
			list[i].id =  processList[i].id;
			list[i].description =  processList[i].description;
			list[i].instructions =  processList[i].instructions;
			list[i].name =  processList[i].name;
			list[i].workSpaceId =  processList[i].workSpaceId;
			ExecutionDTO[] execs = processManager.findExecutions(processList[i].id, 0, System.currentTimeMillis(), "running");
			list[i].state = ProcessListOutDTO.PROCESS_STOPPED;
			list[i].assets = processList[i].assets;
			if(execs.length>0) {
				list[i].state = execs[0].state.equalsIgnoreCase("running") ? ProcessListOutDTO.PROCESS_RUNNING : ProcessListOutDTO.PROCESS_PAUSED;
			}
		}
		return list;
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
	public void editProcess(ProcessInDTO process, Integer processId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProcess(Integer processId) throws BadRequestDataException, UnexpectedException {
		if(processId==null) {
			throw new BadRequestDataException();
		}
		processId = processManager.deleteProcessById(processId);
		
		if(processId == null || processId < 0) {
			throw new UnexpectedException();
		}
	}
	
	@Override
	public ExecutionDTO[] getExecutionByProcess(Integer processId)
			throws BadRequestDataException, UnexpectedException {
		
		if(processId==null) {
			throw new BadRequestDataException();
		}
		ExecutionDTO[] currentExecutions = null;
		try {
			currentExecutions = processManager.findExecutions(processId, 0, System.currentTimeMillis(), null);
		}catch(Exception e) {
			e.printStackTrace();
			throw new UnexpectedException();
		}
		return currentExecutions;
	}
	
	@Override
	public void startExecution(Integer processId) throws BadRequestDataException, UnexpectedException{
		if(processId==null) {
			throw new BadRequestDataException();
		}
		
		ExecutionDTO[] currentExecutions = processManager.findExecutions(processId, 0, System.currentTimeMillis(), "running");
		if(currentExecutions.length>0) {
			throw new BadRequestDataException("Ya este proceso se encuetra corriendo");
		}
		
		currentExecutions = processManager.findExecutions(processId, 0, System.currentTimeMillis(), "paused");
		if(currentExecutions.length>0) {
			continueExecution(currentExecutions[currentExecutions.length-1].id);
			return;
		}
		SaamfiDelegate delegate = new SaamfiDelegate(saamfiUrl);
		String token = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
		
		Integer executionId = processManager.startProcess(processId, delegate.getUsernameFromJWT(token));
		try {
			mqttManager.subscribeToMqtt(executionId+"");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UnexpectedException();
		}
	}
	
	@Override
	public void pauseExecution(Integer processId) throws BadRequestDataException, MqttException {
		
		ExecutionDTO[] currentExecutions = processManager.findExecutions(processId, 0, System.currentTimeMillis(), "running");
		if(currentExecutions.length<=0) {
			throw new BadRequestDataException();
		}
		int executionId = currentExecutions[currentExecutions.length-1].id;
		
		processManager.pauseExecutionProcess(executionId);
		mqttManager.unsubscribeOfMqtt(executionId+"");
	}

	@Override
	public void continueExecution(Integer executionId) throws BadRequestDataException, UnexpectedException{
		
		processManager.continueExecutionProcess(executionId);
		try {
			mqttManager.subscribeToMqtt(executionId+"");
		} catch (Exception e) {
			throw new UnexpectedException();
		}
	}

	@Override
	public void stopExecution(Integer processId) throws BadRequestDataException, MqttException {
		ExecutionDTO[] currentExecutions = processManager.findExecutions(processId, 0, System.currentTimeMillis(), "running");
		if(currentExecutions.length<=0) {
			throw new BadRequestDataException();
		}
		int executionId = currentExecutions[currentExecutions.length-1].id;
		System.out.println("DETENIENDO PROCESO "+executionId);
		processManager.stopExecutionProcess(executionId);
		mqttManager.unsubscribeOfMqtt(executionId+"");
	}
}
