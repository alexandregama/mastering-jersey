package com.mastering.jersey.payment.api;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/api/payment-methods")
public class PaymentMethodResource {

	private PaymentMethods methods = new HashMapPaymentMethods();

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response findBy(@PathParam("id") String id) {
		System.out.println("Searching payment");
		Optional<PaymentMethod> paymentMethod = methods.findByIts(id);
		if (paymentMethod.isPresent()) {
			return Response.ok(paymentMethod.get()).build();
		}

		return Response.status(Status.NOT_FOUND).build();
	}

}
