package com.challenge.ecommerce.tps.product_management.order.api;

import com.challenge.ecommerce.tps.product_management.order.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderApiModelMapper implements OrderApiMapper {

	@Override
	public Order toDomain(OrderRequestDto orderRequestDto) {
		return Order.forCreate(orderRequestDto.totalPrice(), orderRequestDto.productCode());
	}
}
