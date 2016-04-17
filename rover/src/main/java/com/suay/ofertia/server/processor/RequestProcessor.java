package com.suay.ofertia.server.processor;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;


@SuppressWarnings("restriction")
public interface RequestProcessor {

	/**
	 * Process the specified HttpRequest and writes the response
	 * 
	 * @param httpExchange
	 * @throws IOException
	 */
	void processRequest(HttpExchange httpExchange) throws IOException;

}
