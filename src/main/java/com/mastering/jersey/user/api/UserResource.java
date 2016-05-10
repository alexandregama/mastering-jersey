package com.mastering.jersey.user.api;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/api/users")
public class UserResource {

	private Users users = new HashMapUsersDao();
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response findBy(@PathParam("id") Long id) {
		System.out.println("Searching user");
		Optional<User> user = users.findBy(id);
		if (user.isPresent()) {
			return Response.ok(user.get()).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
}
