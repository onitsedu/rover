package com.suay.ofertia.exception.business;

public class CommandFormatException extends Exception {

	private static final String EX_MESSAGE = "incorrect input command format";

	private static final long serialVersionUID = 1L;

	public CommandFormatException() {
		super(EX_MESSAGE);
	}

}
