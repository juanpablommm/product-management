package com.challenge.ecommerce.tps.product_management.order.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {

	private final Long orderId;
	private final BigDecimal totalPrice;
	private final Long buyerId;
	private final Long productId;
	private final String productCode;

	public Order(Long orderId, BigDecimal totalPrice, Long buyerId, Long productId, String productCode) {
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.buyerId = buyerId;
		this.productId = productId;
		this.productCode = productCode;
	}

	public static Order forCreate(BigDecimal bigDecimal, String productCode) {
		return new Order(null, bigDecimal, null, null, productCode);
	}

	public Long getOrderId() {
		return orderId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductCode() {
		return productCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Order order = (Order) o;
		return Objects.equals(getOrderId(), order.getOrderId())
				&& Objects.equals(getTotalPrice(), order.getTotalPrice())
				&& Objects.equals(getBuyerId(), order.getBuyerId())
				&& Objects.equals(getProductId(), order.getProductId())
				&& Objects.equals(getProductCode(), order.getProductCode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getOrderId(), getTotalPrice(), getBuyerId(), getProductId(), getProductCode());
	}

	@Override
	public String toString() {
		return "Order{" + "orderId=" + orderId + ", totalPrice=" + totalPrice + ", buyerId=" + buyerId + ", productId="
				+ productId + ", productCode='" + productCode + '\'' + '}';
	}
}
