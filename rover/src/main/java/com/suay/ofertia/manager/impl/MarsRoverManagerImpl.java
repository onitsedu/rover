package com.suay.ofertia.manager.impl;

import java.util.List;

import com.suay.ofertia.exception.business.CommandFormatException;
import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.manager.MarsRoverManager;
import com.suay.ofertia.rover.commnads.RoverAction;
import com.suay.ofertia.rover.model.Rover;
import com.suay.ofertia.rover.parser.InputParser;
import com.suay.ofertia.utils.Constants;

public class MarsRoverManagerImpl implements MarsRoverManager {

	private static volatile MarsRoverManager instance;

	public static MarsRoverManager getInstance() {
		if (instance == null) {
			synchronized (MarsRoverManager.class) {
				if (instance == null) {
					instance = new MarsRoverManagerImpl();
				}
			}
		}
		return instance;
	}

	@Override
	public String run(String input) throws RoverOutOfPlateauException, CommandFormatException {
		InputParser parser = new InputParser(input);
		StringBuilder sb = new StringBuilder();
		List<Rover> rovers = parser.getRovers();
		for (Rover rover : rovers) {
			for (RoverAction action : rover.getActions()) {
				action.move(rover);
			}
			sb.append(rover.printLocation() + Constants.EOL);
		}
		return sb.toString();

	}
}
