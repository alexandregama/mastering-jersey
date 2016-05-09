package com.mastering.jersey.server;

import java.io.IOException;

import org.glassfish.grizzly.http.server.HttpServer;

public class GrizzlyServerStarter {

	public static void main(String[] args) throws IOException {
		HttpServer server = MainGrizzlyServer.startServer();
		System.out.println("Grizzly Server has been started!");
		
		System.in.read();
		server.shutdown();
		System.out.println("Grizzly Server has been stoped!");
	}
	
}
