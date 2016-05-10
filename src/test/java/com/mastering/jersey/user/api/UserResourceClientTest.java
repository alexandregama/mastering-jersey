package com.mastering.jersey.user.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.mastering.jersey.user.client.User;

public class UserResourceClientTest {

	@Test
	public void shouldRetrieveAUserByItsId() throws Exception {
		User user = ClientBuilder
				.newClient()
				.target("http://localhost:8080")
				.path("app/api/users/1")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.get(User.class);
		
		assertThat(user.getId(), is(equalTo(1L)));
		assertThat(user.getName(), is(equalTo("Alexandre Gama")));
	}
	
}
