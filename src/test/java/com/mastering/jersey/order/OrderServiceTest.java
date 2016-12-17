package com.mastering.jersey.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class OrderServiceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(OrderService.class);
	}
	
	@Test
	public void shouldReturnTheOrderIdFromOrderService() throws Exception {
		String response = target("orders/12").request().get(String.class);
		
		assertThat(response, equalTo("OrderId: 12"));
	}
	
	@Test
	public void shouldReturnTheOrderSummary() throws Exception {
		String response = target("orders/summary").request().get(String.class);
		
		assertThat(response, equalTo("Orders Summary"));
	}
	
}
