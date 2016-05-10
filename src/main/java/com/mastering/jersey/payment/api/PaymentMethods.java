package com.mastering.jersey.payment.api;

import java.util.List;
import java.util.Optional;

public interface PaymentMethods {

	Optional<PaymentMethod> findByIts(String id);

	List<PaymentMethod> listAll();

}
