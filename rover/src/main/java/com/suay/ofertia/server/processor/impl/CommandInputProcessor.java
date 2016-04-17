package com.suay.ofertia.server.processor.impl;

import java.io.IOException;
import java.util.Optional;

import com.suay.ofertia.exception.business.CommandFormatException;
import com.suay.ofertia.exception.business.RoverOutOfPlateauException;
import com.suay.ofertia.utils.Constants;
import com.sun.net.httpserver.HttpExchange;

@SuppressWarnings("restriction")
public class CommandInputProcessor extends AbstractRequestProcessor {
	@Override
	public void processRequest(HttpExchange httpExchange) throws IOException {
		String commands = (String) httpExchange.getAttribute(Constants.HTTP_ATT_BODY);
		try {
			returnOkResponse(httpExchange, Optional.ofNullable(roverManager.run(commands)));
		} catch (RoverOutOfPlateauException | CommandFormatException e) {
			returnBadRequest(httpExchange, Optional.ofNullable(e.getMessage()));
		}
	}
}