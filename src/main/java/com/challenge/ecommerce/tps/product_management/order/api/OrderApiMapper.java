package com.challenge.ecommerce.tps.product_management.order.api;

import com.challenge.ecommerce.tps.product_management.order.domain.Order;

public interface OrderApiMapper {

	Order toDomain(OrderRequestDto orderRequestDto);
}
