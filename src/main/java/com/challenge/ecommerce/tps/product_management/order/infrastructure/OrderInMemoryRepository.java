package com.challenge.ecommerce.tps.product_management.order.infrastructure;

import com.challenge.ecommerce.tps.product_management.order.domain.Order;
import com.challenge.ecommerce.tps.product_management.order.domain.OrderRepository;
import java.util.ArrayList;
import java.util.List;

public class OrderInMemoryRepository implements OrderRepository {

	private final List<Order> orders = new ArrayList<>();

	@Override
	public void save(Order order) {
		this.orders.add(order);
	}

	@Override
	public List<Order> findAll() {
		return this.orders;
	}
}
