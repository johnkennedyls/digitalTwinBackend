package com.icesi.edu.co.pdg.dashboard.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.ProcessInDTO;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.ProcessService;

import icesi.plantapiloto.common.controllers.ProcessManagerControllerPrx;
import icesi.plantapiloto.common.dtos.ProcessDTO;


@Service
public class ProcessServiceImp implements ProcessService{
	
	@Autowired
	private ProcessManagerControllerPrx processManager;
	@Value("${webdasboard.workspace.id}")
	private Integer workspaceId;
	
	@Override
	public ProcessDTO[] getAllProcess() {
		ProcessDTO[] processList = processManager.findProcessByWorkSpace(workspaceId);
		return processList;
	}

	@Override
	public ProcessInDTO getProcess() {
		// TODO Auto-generated method stub
		return null;
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
	public void deleteProcess(Integer processId) {
		
	}
	
	@Override
	public void startExecution(Integer processId) throws BadRequestDataException {
		if(processId==null) {
			throw new BadRequestDataException();
		}
		processManager.startProcess(processId, null);
	}

	@Override
	public void pauseExecution(Integer executionId) throws BadRequestDataException {
		if(executionId==null) {
			throw new BadRequestDataException();
		}
		processManager.pauseExecutionProcess(executionId);
	}

	@Override
	public void continueExecution(Integer executionId) throws BadRequestDataException {
		if(executionId==null) {
			throw new BadRequestDataException();
		}
		processManager.continueExecutionProcess(executionId);
	}

	@Override
	public void stopExecution(Integer executionId) throws BadRequestDataException {
		if(executionId==null) {
			throw new BadRequestDataException();
		}
		processManager.stopExecutionProcess(executionId);
	}
	
}
