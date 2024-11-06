package com.challenge.ecommerce.tps.product_management.order;

import com.challenge.ecommerce.tps.product_management.order.domain.Order;
import java.math.BigDecimal;

public class OrderMother {

	private Long orderId = 1L;
	private BigDecimal totalPrice = BigDecimal.valueOf(200.00);
	private Long buyerId = 10L;
	private Long sellerId = 20L;

	public OrderMother withOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public OrderMother withTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	public OrderMother withBuyerId(Long buyerId) {
		this.buyerId = buyerId;
		return this;
	}

	public OrderMother withSellerId(Long sellerId) {
		this.sellerId = sellerId;
		return this;
	}

	public Order build() {
		return new Order(orderId, totalPrice, buyerId, sellerId);
	}
}
