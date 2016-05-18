package com.mastering.jersey.payment.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HashMapPaymentMethods implements PaymentMethods {

	private static final Map<String, PaymentMethod> table = new HashMap<>();
	
	static {
		table.put("visa", new PaymentMethod("visa", "Visa"));
		table.put("master", new PaymentMethod("master", "Master"));
	}
	
	@Override
	public Optional<PaymentMethod> findByIts(String id) {
		Optional<PaymentMethod> paymentMethod = Optional.ofNullable(table.get(id));
		
		return paymentMethod;
	}

	@Override
	public List<PaymentMethod> listAll() {
		return new ArrayList<>(table.values());
	}

}
