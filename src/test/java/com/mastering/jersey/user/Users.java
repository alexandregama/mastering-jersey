package com.mastering.jersey.user;

import java.util.Optional;

public interface Users {

	Optional<User> findBy(Long id);

}
