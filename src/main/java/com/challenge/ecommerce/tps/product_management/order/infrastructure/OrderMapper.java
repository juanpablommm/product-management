package com.challenge.ecommerce.tps.product_management.order.infrastructure;

import com.challenge.ecommerce.tps.product_management.order.domain.Order;

public interface OrderMapper {

	OrderEntity toJpaEntity(final Order order);

	Order toDomain(final OrderEntity orderEntity);
}
