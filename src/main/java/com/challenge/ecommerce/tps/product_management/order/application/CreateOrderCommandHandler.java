package com.challenge.ecommerce.tps.product_management.order.application;

import com.challenge.ecommerce.tps.product_management.order.domain.Order;
import com.challenge.ecommerce.tps.product_management.order.domain.OrderRepository;

public class CreateOrderCommandHandler {

	private final OrderRepository orderRepository;

	public CreateOrderCommandHandler(OrderRepository orderJpaRepository) {
		this.orderRepository = orderJpaRepository;
	}

	public void handler(final Order order) {
		this.orderRepository.save(order);
	}
}
