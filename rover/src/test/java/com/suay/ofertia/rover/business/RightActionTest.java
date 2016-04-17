package com.suay.ofertia.rover.business;

import org.junit.Assert;
import org.junit.Test;

import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.BaseTest;
import com.suay.ofertia.rover.commnads.RoverAction;
import com.suay.ofertia.rover.commnads.impl.TurnRightAction;
import com.suay.ofertia.rover.model.Direction;
import com.suay.ofertia.rover.model.Rover;

public class RightActionTest extends BaseTest {

	@Test
	public void moveOneStep() throws RoverOutOfPlateauException {

		RoverAction move = new TurnRightAction();
		Rover rover = new Rover(0, 0, Direction.N, plateau);
		move.move(rover);

		Assert.assertEquals("0 0 E", rover.printLocation());
	}

}
