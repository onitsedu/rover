package com.suay.ofertia.rover;

import org.junit.Assert;
import org.junit.Test;

import com.suay.ofertia.exception.business.CommandFormatException;
import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.manager.impl.MarsRoverManagerImpl;

public class MarsRoverTest {
	private final static String TEST_COMMAND = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

	@Test
	public void testApp() throws RoverOutOfPlateauException, CommandFormatException {

		MarsRoverManagerImpl app = new MarsRoverManagerImpl();
		String result = app.run(TEST_COMMAND);
		System.out.println(result);
		Assert.assertEquals(result, "1 3 N\n5 1 E\n", result);
	}
}
