package com.mastering.jersey.user.api;

import java.util.Optional;

public interface Users {

	Optional<User> findBy(Long id);

}
