package com.suay.ofertia;

import java.util.logging.Logger;

import com.suay.ofertia.server.http.RoverHttpServer;
import com.suay.ofertia.server.http.impl.RoverHttpServerImpl;
import com.suay.ofertia.utils.Constants;

public class MainRoverServer {
	private static final Logger LOGGER = Logger.getLogger(MainRoverServer.class.getName());

	public static void main(String[] args) {
		final Integer port = calculatePort(args);
		buildRoverServer().startServer(port);
	}

	private static Integer calculatePort(String[] args) {
		if (args.length == 1) {
			try {
				return Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				LOGGER.warning("Error parsing arguments.");
				LOGGER.warning(e.getMessage());
			}
		} else {
			LOGGER.warning("Usage--> java -jar OfertiaMarsRover-X.X.jar [portNumber](optional)");
		}

		LOGGER.warning("Using default port " + Constants.PORT);
		return Constants.PORT;
	}

	private static RoverHttpServer buildRoverServer() {
		return new RoverHttpServerImpl();
	}
}
