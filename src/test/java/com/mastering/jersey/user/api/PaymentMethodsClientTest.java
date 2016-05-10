package com.mastering.jersey.user.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.mastering.jersey.payment.client.PaymentMethod;

public class PaymentMethodsClientTest {

	@Test
	public void shouldRetrieveAPaymentMethodByItsId() throws Exception {
		PaymentMethod paymentMethod = ClientBuilder
			.newClient()
			.target("http://localhost:8080/app")
			.path("api/payment-methods/visa")
			.request(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.get(PaymentMethod.class);
		
		assertThat(paymentMethod.getId(), is(equalTo("visa")));
		assertThat(paymentMethod.getName(), is(equalTo("Visa")));
	}
	
	@Test
	public void shouldRetrieveAListOfPayments() throws Exception {
		Response response = ClientBuilder
			.newClient()
			.target("http://localhost:8080/app")
			.path("api/payment-methods")
			.request(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.get();
		
		List<PaymentMethod> paymentMethods = response.readEntity(new GenericType<List<PaymentMethod>>() {});
		
		assertThat(paymentMethods.size(), is(equalTo(2)));
		assertTrue(paymentMethods.stream().anyMatch(p -> p.getId().equals("visa")));
		assertTrue(paymentMethods.stream().anyMatch(p -> p.getId().equals("master")));
		
		assertTrue(paymentMethods.stream().anyMatch(p -> p.getName().equals("Visa")));
		assertTrue(paymentMethods.stream().anyMatch(p -> p.getName().equals("Master")));
	}
	
}
