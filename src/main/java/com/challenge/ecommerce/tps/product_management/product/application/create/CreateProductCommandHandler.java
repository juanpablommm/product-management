package com.challenge.ecommerce.tps.product_management.product.application.create;

import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import jakarta.transaction.Transactional;

public class CreateProductCommandHandler {

	private final ProductRepository productRepository;

	public CreateProductCommandHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional
	public void handler(final Product product) {
		this.productRepository.create(product);
	}
}
