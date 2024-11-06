package com.challenge.ecommerce.tps.product_management.order.infrastructure;

import com.challenge.ecommerce.tps.product_management.order.domain.Order;
import com.challenge.ecommerce.tps.product_management.product.infrastructure.ProductEntity;
import com.challenge.ecommerce.tps.product_management.user.infrastructure.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderModelMapper implements OrderMapper {

	@Override
	public OrderEntity toJpaEntity(final Order order) {

		return OrderEntity.builder().buyer(UserEntity.builder().userId(order.getBuyerId()).build())
				.productEntity(ProductEntity.builder().productId(order.getProductId()).build())
				.totalPrice(order.getTotalPrice()).build();
	}

	@Override
	public Order toDomain(final OrderEntity orderEntity) {
		return new Order(orderEntity.getOrderId(), orderEntity.getTotalPrice(), orderEntity.getBuyer().getUserId(),
				orderEntity.getProductEntity().getProductId(), orderEntity.getProductEntity().getProductCode());
	}
}
