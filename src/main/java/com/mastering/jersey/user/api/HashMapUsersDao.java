package com.mastering.jersey.user.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HashMapUsersDao implements Users {

	private static final Map<Long, User> table = new HashMap<>();
	
	static {
		table.put(1L, new User(1L, "Alexandre Gama"));
		table.put(2L, new User(2L, "Fernando Gama"));
		table.put(3L, new User(3L, "Marcia Gama"));
		table.put(4L, new User(4L, "Bia Gama"));
	}
	
	public Optional<User> findBy(Long id) {
		User user = table.get(id);
		
		return Optional.ofNullable(user);
	}

}
