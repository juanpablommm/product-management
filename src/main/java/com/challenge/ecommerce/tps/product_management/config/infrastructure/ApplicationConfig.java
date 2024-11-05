package com.challenge.ecommerce.tps.product_management.config.infrastructure;

import com.challenge.ecommerce.tps.product_management.product.application.create.CreateProductCommandHandler;
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
}
