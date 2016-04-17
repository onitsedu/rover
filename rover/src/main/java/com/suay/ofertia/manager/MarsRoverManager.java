package com.suay.ofertia.manager;

import com.suay.ofertia.exception.business.CommandFormatException;
import com.suay.ofertia.exception.business.RoverOutOfPlateauException;

public interface MarsRoverManager {
	public String run(String input) throws RoverOutOfPlateauException, CommandFormatException;

}
