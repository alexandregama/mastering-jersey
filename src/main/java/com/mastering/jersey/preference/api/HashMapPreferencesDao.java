package com.mastering.jersey.preference.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HashMapPreferencesDao implements Preferences {

	private static final Map<Long, Preference> table = new HashMap<>();
	
	static {
		Preference preferenceFirstProduct = new Preference();
		preferenceFirstProduct.addItem(new Item(1L, "First Product"));
		Preference preferenceSecondProduct = new Preference();
		preferenceSecondProduct.addItem(new Item(2L, "Second Product"));
		
		table.put(1L, preferenceFirstProduct);
		table.put(2L, preferenceSecondProduct);
	}
	
	@Override
	public Optional<Preference> getPreferenceBy(Long id) {
		return Optional.ofNullable(table.get(id));
	}
	
}
