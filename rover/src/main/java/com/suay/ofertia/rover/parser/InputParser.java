package com.suay.ofertia.rover.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.suay.ofertia.exception.business.CommandFormatException;
import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.rover.commnads.RoverAction;
import com.suay.ofertia.rover.commnads.impl.MoveAction;
import com.suay.ofertia.rover.commnads.impl.TurnLeftAction;
import com.suay.ofertia.rover.commnads.impl.TurnRightAction;
import com.suay.ofertia.rover.model.Direction;
import com.suay.ofertia.rover.model.Plateau;
import com.suay.ofertia.rover.model.Rover;
import com.suay.ofertia.utils.Constants;

public class InputParser {

	private static final Logger LOGGER = Logger.getLogger(InputParser.class.getName());

	private static final Map<String, RoverAction> actions;

	private String command;
	private Plateau plateau;

	static {
		actions = new HashMap<>();
		actions.put(Constants.RIGHT, new TurnRightAction());
		actions.put(Constants.LEFT, new TurnLeftAction());
		actions.put(Constants.MOVE, new MoveAction());
	}

	public InputParser(String command) {
		this.command = command;
	}

	private List<RoverAction> getRoverActions(String command) throws CommandFormatException {
		List<RoverAction> actionsList = new ArrayList<>();
		for (String action : command.split(Constants.COMMAND_SPLIT)) {

			RoverAction roverAction = actions.get(action);
			if (roverAction == null) {
				throw new CommandFormatException();
			}
			actionsList.add(roverAction);
		}
		return actionsList;
	}

	private Plateau parsePleateauCommnad(String command) throws CommandFormatException {
		Plateau p = null;
		String[] coords = command.split(Constants.COMMAND_SEPARATOR);
		try {

			Integer upperCoord = Integer.parseInt(coords[0]);
			Integer rightCord = Integer.parseInt(coords[1]);
			p = new Plateau(upperCoord, rightCord);

		} catch (NumberFormatException e) {
			LOGGER.severe("error parsing command number " + e.getMessage());
			throw new CommandFormatException();
		}

		return p;
	}

	private Rover initRoverPosition(String command) throws CommandFormatException, RoverOutOfPlateauException {
		Rover r = null;
		String[] coords = command.split(Constants.COMMAND_SEPARATOR);
		try {

			Integer xPosition = Integer.parseInt(coords[0]);
			Integer yPosition = Integer.parseInt(coords[1]);

			Direction direct = Direction.valueOf(coords[2]);

			r = new Rover(xPosition, yPosition, direct, plateau);
			if (!plateau.isRoverOnPlateau(r)) {
				throw new RoverOutOfPlateauException();
			}

		} catch (NumberFormatException e) {
			LOGGER.severe("error parsing command number " + e);

			throw new CommandFormatException();
		}

		return r;
	}

	private List<String> splitCommandLines(String command) throws CommandFormatException {
		List<String> lines = new ArrayList<>();
		BufferedReader br = new BufferedReader(new StringReader(command));
		String line;
		try {
			line = br.readLine();
			while (line != null) {
				lines.add(line.trim());
				line = br.readLine();
			}
		} catch (IOException e) {
			LOGGER.severe("error readeing command" + e.getMessage());
			throw new CommandFormatException();
		}
		return lines;
	}

	public List<Rover> getRovers() throws CommandFormatException, RoverOutOfPlateauException {

		List<Rover> rovers = new ArrayList<>();

		List<String> commands = splitCommandLines(command);

		if ((commands.size() - 1) % 2 != 0) {
			throw new CommandFormatException();
		}
		plateau = parsePleateauCommnad(commands.get(0));
		Rover r;
		List<RoverAction> actionsList;

		for (int i = 1; i < commands.size(); i = i + 2) {
			r = initRoverPosition(commands.get(i));
			actionsList = getRoverActions(commands.get(i + 1));
			r.setActions(actionsList);
			rovers.add(r);

		}

		return rovers;
	}
}
