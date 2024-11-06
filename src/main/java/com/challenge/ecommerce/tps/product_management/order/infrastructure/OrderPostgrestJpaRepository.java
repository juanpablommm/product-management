package com.challenge.ecommerce.tps.product_management.order.infrastructure;

import com.challenge.ecommerce.tps.product_management.order.domain.Order;
import com.challenge.ecommerce.tps.product_management.order.domain.OrderRepository;
import com.challenge.ecommerce.tps.product_management.product.infrastructure.ProductEntity;
import com.challenge.ecommerce.tps.product_management.product.infrastructure.ProductJpaRepository;
import com.challenge.ecommerce.tps.product_management.user.infrastructure.UserEntity;
import com.challenge.ecommerce.tps.product_management.user.infrastructure.UserJpaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class OrderPostgrestJpaRepository implements OrderRepository {

	private final OrderJpaRepository orderJpaRepository;
	private final UserJpaRepository userJpaRepository;
	private final ProductJpaRepository productJpaRepository;
	private final OrderMapper orderMapper;

	@Transactional
	@Override
	public void save(Order order) {
		final String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		final Long buyerUserId = this.userJpaRepository.findUserIdByEmail(email);
		final OrderEntity orderEntity = this.orderMapper.toJpaEntity(order);
		final Long productId = this.productJpaRepository.findByProductCode(order.getProductCode());
		orderEntity.setBuyer(UserEntity.builder().userId(buyerUserId).build());
		orderEntity.setProductEntity(ProductEntity.builder().productId(productId).build());
		this.orderJpaRepository.save(orderEntity);
	}

	@Override
	public List<Order> findAll() {
		final List<OrderEntity> orders = this.orderJpaRepository.findAll();
		return orders.stream().map(this.orderMapper::toDomain).toList();
	}
}
