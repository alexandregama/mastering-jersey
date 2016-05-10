package com.mastering.jersey.user.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

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
	
}
