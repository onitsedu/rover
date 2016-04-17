package com.suay.ofertia.exception.business;

public class RoverOutOfPlateauException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String EX_MESSAGE = "the rover is out of the plateau";

	public RoverOutOfPlateauException() {
		super(EX_MESSAGE);
	}

}
