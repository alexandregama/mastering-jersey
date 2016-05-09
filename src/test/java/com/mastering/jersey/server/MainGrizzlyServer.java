package com.mastering.jersey.server;

import java.net.URI;
import java.util.Optional;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class MainGrizzlyServer {

	public static final String BASE_URI;
	private static final String protocol;
	private static final Optional<String> host;
	private static final String path;
	private static final Optional<String> port;
	
	static {
		protocol = "http://";
		host = Optional.ofNullable(System.getenv("HOSTNAME"));
		port = Optional.ofNullable(System.getenv("PORT"));
		path = "myapp";
		BASE_URI = protocol + host.orElse("localhost") + ":" + port.orElse("8080") + "/" + path + "/";
	}
	
	public static HttpServer startServer() {
		ResourceConfig config = new ResourceConfig().packages("com.mastering.jersey.user");
		
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
		
		return server;
	}
	
}
