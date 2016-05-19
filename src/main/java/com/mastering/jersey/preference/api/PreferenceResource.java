package com.mastering.jersey.preference.api;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/api/checkout/preferences")
public class PreferenceResource {

	private Preferences preferences = new HashMapPreferencesDao();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPreference(Preference preference) {
		return Response.ok().build();
	}
	
	/**
	 * JSON format
	 * {"items":[{"id":1,"title":"First Product"}]} 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getPreferenceBy(@PathParam("id") Long id) {
		Optional<Preference> preference = preferences.getPreferenceBy(id);
		if (!preference.isPresent()) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Response response = Response
				.ok(preference.get())
				.build();
		return response;
	}
	
}
