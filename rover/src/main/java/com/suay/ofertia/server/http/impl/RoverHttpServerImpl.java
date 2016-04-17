package com.suay.ofertia.server.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import com.suay.ofertia.server.filter.HttpFilter;
import com.suay.ofertia.server.handler.RoverHttpHandler;
import com.suay.ofertia.server.http.RoverHttpServer;
import com.suay.ofertia.utils.Constants;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class RoverHttpServerImpl implements RoverHttpServer {
	private static final Logger LOGGER = Logger.getLogger(RoverHttpServerImpl.class.getName());

	private HttpServer httpServer;

	@Override
	public void startServer(Integer port) {
		String hostName = resolveHostName();
		try {
			LOGGER.info("Starting HTTPServer.");
			doStart(port);
			LOGGER.info("HTTPServer started at http://" + hostName + ":" + port + "/");
			LOGGER.info("Started HTTPServer Successfully!\n");
		} catch (IOException e) {
			LOGGER.warning("Error with the HTTPServer.");
			LOGGER.warning(e.getMessage());
		}
	}

	@Override
	public void stopServer() {

		httpServer.stop(0);
	}

	private void doStart(Integer port) throws IOException {
		httpServer = HttpServer.create(new InetSocketAddress(port), 0);
		HttpContext httpContext = httpServer.createContext("/", new RoverHttpHandler());
		httpContext.getFilters().add(new HttpFilter());
		httpServer.setExecutor(Executors.newCachedThreadPool());
		httpServer.start();
	}

	private String resolveHostName() {
		String hostName = null;
		try {
			hostName = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException ex) {
			LOGGER.warning("Unknown Host: " + ex);
		}
		return hostName != null ? hostName : Constants.LOCALHOST;
	}

}
