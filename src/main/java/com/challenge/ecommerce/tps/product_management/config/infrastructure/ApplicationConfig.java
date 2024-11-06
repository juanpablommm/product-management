package com.challenge.ecommerce.tps.product_management.config.infrastructure;

import com.challenge.ecommerce.tps.product_management.order.application.CreateOrderCommandHandler;
import com.challenge.ecommerce.tps.product_management.order.domain.OrderRepository;
import com.challenge.ecommerce.tps.product_management.product.application.create.CreateProductCommandHandler;
import com.challenge.ecommerce.tps.product_management.product.application.finaAll.FindAllCommandHandler;
import com.challenge.ecommerce.tps.product_management.product.application.find.FindProductCommandHandler;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public CreateProductCommandHandler createProductCommandHandler(final ProductRepository productRepository) {
		return new CreateProductCommandHandler(productRepository);
	}

	@Bean
	public FindProductCommandHandler findProductCommandHandler(final ProductRepository productRepository) {
		return new FindProductCommandHandler(productRepository);
	}

	@Bean
	public CreateOrderCommandHandler createOrderCommandHandler(final OrderRepository orderRepository) {
		return new CreateOrderCommandHandler(orderRepository);
	}

	@Bean
	public FindAllCommandHandler findAllCommandHandler(final ProductRepository productRepository) {
		return new FindAllCommandHandler(productRepository);
	}
}
