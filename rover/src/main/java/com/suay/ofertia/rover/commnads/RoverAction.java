package com.suay.ofertia.rover.commnads;

import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.model.Rover;

public interface RoverAction {

	void move(Rover rover) throws RoverOutOfPlateauException;

}
