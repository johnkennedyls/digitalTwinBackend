package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import icesi.plantapiloto.common.dtos.ProcessDTO;

public class ProcessListOutDTO extends ProcessDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static Integer PROCESS_STOPPED=0;
	public final static Integer PROCESS_RUNNING=1;
	public final static Integer PROCESS_PAUSED=2;
	
	public Integer state;
}
