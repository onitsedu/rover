package com.suay.ofertia.rover.parser;

import org.junit.Assert;
import org.junit.Test;

import com.suay.ofertia.exception.business.CommandFormatException;
import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.BaseTest;
import com.suay.ofertia.rover.model.Rover;

public class InputParserTest extends BaseTest {

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
