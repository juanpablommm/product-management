package com.challenge.ecommerce.tps.product_management.order.api;

import com.challenge.ecommerce.tps.product_management.order.application.CreateOrderCommandHandler;
import com.challenge.ecommerce.tps.product_management.order.domain.Order;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
@AllArgsConstructor
public class OrderController {

	private final CreateOrderCommandHandler createOrderCommandHandler;
	private final OrderApiMapper orderApiMapper;

	@PostMapping(path = "/create")
	public ResponseEntity<?> createOrder(@RequestBody @Valid OrderRequestDto orderRequestDto) {
		final Order order = this.orderApiMapper.toDomain(orderRequestDto);
		this.createOrderCommandHandler.handler(order);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
