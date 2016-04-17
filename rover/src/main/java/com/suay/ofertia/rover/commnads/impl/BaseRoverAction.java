package com.suay.ofertia.rover.commnads.impl;

import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.commnads.RoverAction;
import com.suay.ofertia.rover.model.Rover;

public abstract class BaseRoverAction implements RoverAction {

	protected void testRoverPosition(Rover rover) throws RoverOutOfPlateauException {
		if (!rover.getPlateau().isRoverOnPlateau(rover)) {
			throw new RoverOutOfPlateauException();
		}
	}
}
