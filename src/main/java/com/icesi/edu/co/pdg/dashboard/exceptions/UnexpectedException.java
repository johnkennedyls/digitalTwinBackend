package com.icesi.edu.co.pdg.dashboard.exceptions;

public class UnexpectedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4790655428456135563L;
	
	public UnexpectedException(String message) {
		super(message);
	}
	public UnexpectedException() {
		super("Error interno, Intente mas tarde");
	}

}
