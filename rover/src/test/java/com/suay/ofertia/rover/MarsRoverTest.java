package com.suay.ofertia.rover;

import org.junit.Assert;
import org.junit.Test;

import com.suay.ofertia.exception.business.CommandFormatException;
import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.manager.MarsRoverManager;
import com.suay.ofertia.manager.impl.MarsRoverManagerImpl;

public class MarsRoverTest {

	private final static String TEST_COMMAND = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

	private final static String OUT_OF_BOUNDS_COMMAND = "5 5\n1 5 N\nMMMMMMM";

	private final static String BAD_COMMAND = "5 51 2 N\nLMLMLML";
	
	private final static String TURN_RIGHT_COMMAND = "5 5\n1 5 N\nR";

	private final static String TURN_LEFT_COMMAND = "5 5\n1 4 N\nL";

	private final static String MOVE_COMMAND = "5 5\n1 5 N\nM";

	
	@Test
	public void testRover() throws RoverOutOfPlateauException, CommandFormatException {

		MarsRoverManager roverManager = new MarsRoverManagerImpl();
		String result = roverManager.run(TEST_COMMAND);

		Assert.assertEquals(result, "1 3 N\n5 1 E\n", result);
	}
	@Test
	public void testTurnRightRover() throws RoverOutOfPlateauException, CommandFormatException {

		MarsRoverManager roverManager = new MarsRoverManagerImpl();
		String result = roverManager.run(TURN_RIGHT_COMMAND);

		Assert.assertEquals(result, "1 5 E\n", result);
	}
	@Test
	public void testTurnLeftRover() throws RoverOutOfPlateauException, CommandFormatException {

		MarsRoverManager roverManager = new MarsRoverManagerImpl();
		String result = roverManager.run(TURN_LEFT_COMMAND);

		Assert.assertEquals(result, "1 5 W\n", result);
	}
	@Test
	public void testMoveRover() throws RoverOutOfPlateauException, CommandFormatException {

		MarsRoverManager roverManager = new MarsRoverManagerImpl();
		String result = roverManager.run(MOVE_COMMAND);

		Assert.assertEquals(result, "1 5 N", result);
	}
	
	

	@Test(expected = CommandFormatException.class)
	public void testBadCommandRover() throws RoverOutOfPlateauException, CommandFormatException {

		MarsRoverManager roverManager = new MarsRoverManagerImpl();
		roverManager.run(BAD_COMMAND);
	}

	@Test(expected = RoverOutOfPlateauException.class)
	public void testOutOfBoundsPathRover() throws RoverOutOfPlateauException, CommandFormatException {

		MarsRoverManagerImpl roverManager = new MarsRoverManagerImpl();
		roverManager.run(OUT_OF_BOUNDS_COMMAND);
	}
}
