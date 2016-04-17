package com.suay.ofertia.rover.commnads.impl;

import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.model.Rover;

public class TurnLeftAction extends BaseRoverAction {

	@Override
	public void move(Rover rover) throws RoverOutOfPlateauException {
		rover.setDirection(rover.getDirection().leftDirection());
		super.testRoverPosition(rover);
	}

}
