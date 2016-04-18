package com.suay.ofertia.rover;

import com.suay.ofertia.rover.model.Plateau;

public abstract class BaseTest {

	protected static final Plateau plateau = new Plateau(5, 5);

	protected final static String TEST_COMMAND = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

	protected final static String OUT_OF_BOUNDS_COMMAND = "5 5\n1 5 N\nMMMMMMM";

	protected final static String BAD_COMMAND = "5 51 2 N\nLMLMLML";

	protected final static String TURN_RIGHT_COMMAND = "5 5\n1 5 N\nR";

	protected final static String TURN_LEFT_COMMAND = "5 5\n1 5 N\nL";

	protected final static String MOVE_COMMAND = "5 5\n1 4 N\nM";

	protected final static String ROVER_OUT_COMMAND = "5 5\n1 6 N\nLMLMLMLMM";

}
