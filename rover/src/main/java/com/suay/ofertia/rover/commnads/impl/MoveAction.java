package com.suay.ofertia.rover.commnads.impl;

import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.model.Rover;

public class MoveAction extends BaseRoverAction {

	@Override
	public void move(Rover rover) throws RoverOutOfPlateauException {
		rover.setxPosition(rover.getxPosition() + rover.getDirection().getxStep());
		rover.setyPosition(rover.getyPosition() + rover.getDirection().getyStep());
		super.testRoverPosition(rover);
	}

}
