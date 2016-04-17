package com.suay.ofertia.server.processor.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Optional;

import com.suay.ofertia.manager.MarsRoverManager;
import com.suay.ofertia.manager.impl.MarsRoverManagerImpl;
import com.suay.ofertia.server.processor.RequestProcessor;
import com.suay.ofertia.utils.Constants;
import com.sun.net.httpserver.HttpExchange;


@SuppressWarnings("restriction")
public abstract class AbstractRequestProcessor implements RequestProcessor {

	protected MarsRoverManager roverManager = MarsRoverManagerImpl.getInstance();

	private void writeResponse(HttpExchange httpExchange, String httpBody, Integer httpCode) throws IOException {
		httpExchange.getResponseHeaders().add(Constants.CONTENT_TYPE, Constants.CONTENT_TEXT);
		httpExchange.sendResponseHeaders(httpCode, httpBody.length());
		OutputStream os = httpExchange.getResponseBody();
		os.write(httpBody.getBytes());
		os.close();
	}

	protected void returnBadRequest(HttpExchange httpExchange, Optional<String> body) throws IOException {
		writeResponse(httpExchange, body.orElse(""), HttpURLConnection.HTTP_BAD_REQUEST);
	}

	protected void returnNotFound(HttpExchange httpExchange, Optional<String> body) throws IOException {
		writeResponse(httpExchange, body.orElse(""), HttpURLConnection.HTTP_NOT_FOUND);
	}

	protected void returnOkResponse(HttpExchange httpExchange, Optional<String> body) throws IOException {
		writeResponse(httpExchange, body.orElse(""), HttpURLConnection.HTTP_OK);
	}
}