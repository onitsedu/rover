package com.suay.ofertia.server.http;


public interface RoverHttpServer {

    /**
     * Starts the server in the specified port
     * 
     * @param port
     */
    void startServer(Integer port);

    /**
     * stops the server
     */
    void stopServer();

}
