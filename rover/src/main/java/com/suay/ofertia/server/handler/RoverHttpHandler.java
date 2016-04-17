package com.suay.ofertia.server.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.suay.ofertia.exception.http.BadMethodException;
import com.suay.ofertia.exception.http.HttpException;
import com.suay.ofertia.exception.http.PageNotFoundException;
import com.suay.ofertia.server.processor.RequestProcessor;
import com.suay.ofertia.server.processor.impl.CommandInputProcessor;
import com.suay.ofertia.utils.Constants;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class RoverHttpHandler implements HttpHandler {

	Map<String, RequestProcessor> requestProcessors;

	public RoverHttpHandler() {
		requestProcessors = new HashMap<>();
		requestProcessors.put(Constants.COMMAND_REQUEST, new CommandInputProcessor());
	}

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {

		String request;
		try {
			request = matchPath(httpExchange);
			RequestProcessor requestProcessor = requestProcessors.get(request);
			requestProcessor.processRequest(httpExchange);
		} catch (HttpException e) {
			writeErrorResponse(httpExchange, e);
		}

	}

	protected void writeErrorResponse(HttpExchange httpExchange, HttpException e) throws IOException {
		httpExchange.getResponseHeaders().add(Constants.CONTENT_TYPE, Constants.CONTENT_TEXT);
		httpExchange.sendResponseHeaders(e.getHttpCode(), e.getHttpMessage().length());
		OutputStream os = httpExchange.getResponseBody();
		os.write(e.getHttpMessage().getBytes());
		os.close();
	}

	private String matchPath(HttpExchange httpExchange) throws HttpException {
		String uri = httpExchange.getRequestURI().toString();
		String method = httpExchange.getRequestMethod();
		if (uri.matches(Constants.COMMAND_PATTERN)) {
			if (Constants.HTTP_POST.equalsIgnoreCase(method)) {
				return Constants.COMMAND_REQUEST;
			} else {
				throw new BadMethodException();
			}
		} else {
			throw new PageNotFoundException();
		}

	}
}
