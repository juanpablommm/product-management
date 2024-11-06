package com.challenge.ecommerce.tps.product_management.order.domain;

import java.util.List;

public interface OrderRepository {

	void save(Order order);

	List<Order> findAll();
}
