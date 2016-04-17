package com.suay.ofertia.rover.business;

import org.junit.Assert;
import org.junit.Test;

import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.BaseTest;
import com.suay.ofertia.rover.commnads.RoverAction;
import com.suay.ofertia.rover.commnads.impl.MoveAction;
import com.suay.ofertia.rover.model.Direction;
import com.suay.ofertia.rover.model.Rover;

public class MoveActionTest extends BaseTest {

	@Test
	public void moveOneStep() throws RoverOutOfPlateauException {

		RoverAction move = new MoveAction();
		Rover rover = new Rover(0, 0, Direction.N, plateau);
		move.move(rover);

		Assert.assertEquals("0 1 N", rover.printLocation());
	}

	@Test(expected = RoverOutOfPlateauException.class)
	public void moveOutOFBoundsStep() throws RoverOutOfPlateauException {

		RoverAction move = new MoveAction();
		Rover rover = new Rover(0, 0, Direction.S, plateau);
		move.move(rover);

	}

}
