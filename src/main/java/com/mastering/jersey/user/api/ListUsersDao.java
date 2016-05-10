package com.mastering.jersey.user.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ListUsersDao implements Users {

	private static final Map<Long, User> users = new HashMap<>();
	
	static {
		users.put(1L, new User(1L, "Alexandre Gama"));
		users.put(2L, new User(2L, "Fernando Gama"));
		users.put(3L, new User(3L, "Marcia Gama"));
		users.put(4L, new User(4L, "Bia Gama"));
	}
	
	public Optional<User> findBy(Long id) {
		User user = users.get(id);
		
		return Optional.ofNullable(user);
	}

}
