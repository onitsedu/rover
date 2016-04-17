package com.suay.ofertia.rover.parser;

import org.junit.Assert;
import org.junit.Test;

import com.suay.ofertia.exception.business.CommandFormatException;
import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.model.Rover;

public class InputParserTest {

	private final static String TEST_COMMAND = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

	private final static String BAD_COMMAND = "5 51 2 N\nLMLMLML";

	private final static String ROVER_OUT_COMMAND = "5 5\n1 6 N\nLMLMLMLMM";

	@Test
	public void testCommandParse() throws CommandFormatException, RoverOutOfPlateauException {

		InputParser p = new InputParser(TEST_COMMAND);
		p.getRovers();

		Assert.assertTrue(p.getRovers().size() == 2);
		Rover firstRover = p.getRovers().get(0);
		Assert.assertEquals("1 2 N", firstRover.printLocation());
		Assert.assertTrue(firstRover.getPlateau().isRoverOnPlateau(firstRover));
	}

	@Test(expected = CommandFormatException.class)
	public void testBadCommand() throws CommandFormatException, RoverOutOfPlateauException {
		InputParser p = new InputParser(BAD_COMMAND);
		p.getRovers();
	}

	@Test(expected = RoverOutOfPlateauException.class)
	public void testRoverOutCommand() throws CommandFormatException, RoverOutOfPlateauException {
		InputParser p = new InputParser(ROVER_OUT_COMMAND);
		p.getRovers();
	}

}
