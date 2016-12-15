package com.mastering.jersey.preference.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.mastering.jersey.preference.api.Preference;

public class PreferenceClient {

	public Preference getBy(Long id) {
		Preference preference = ClientBuilder.newClient()
			.target("http://localhost:8080/app/")
			.path("api/checkout/preferences/"+id)
			.request()
			.accept(MediaType.APPLICATION_JSON_TYPE)
			.get(Preference.class);
		
		return preference;
	}
	
}
