package com.mastering.jersey.order;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("orders")
public class OrderService {

	@GET
	@Path("{orderId}")
	public String getOrders(@PathParam("orderId") String orderId) {
		return "OrderId: " + orderId;
	}
	
	@GET
	@Path("summary")
	public String getSummary() {
		return "Orders Summary";
	}
	
}
