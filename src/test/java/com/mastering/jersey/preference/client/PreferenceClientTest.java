package com.mastering.jersey.preference.client;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.mastering.jersey.preference.api.Item;
import com.mastering.jersey.preference.api.Preference;

public class PreferenceClientTest {

	@Test
	public void shouldGetPreferencesFromItsId() throws Exception {
		PreferenceClient client = new PreferenceClient();
		
		Preference preference = client.getBy(1L);
		
		Item firstItem = preference.getItems().get(0);
		
		assertThat(firstItem.getId(), is(equalTo(1L)));
		assertThat(firstItem.getTitle(), is(equalTo("First Product")));
	}
	
}
