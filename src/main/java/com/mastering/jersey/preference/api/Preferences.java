package com.mastering.jersey.preference.api;

import java.util.Optional;

public interface Preferences {

	Optional<Preference> getPreferenceBy(Long id);
	
}
