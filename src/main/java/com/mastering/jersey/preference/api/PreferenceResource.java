package com.mastering.jersey.preference.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/checkout/preferences")
public class PreferenceResource {

	@POST
	public Response createPreference() {
		return Response.ok().build();
	}
	
}
