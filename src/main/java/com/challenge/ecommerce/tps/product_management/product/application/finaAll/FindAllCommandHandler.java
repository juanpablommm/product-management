package com.challenge.ecommerce.tps.product_management.product.application.finaAll;

import com.challenge.ecommerce.tps.product_management.product.application.ProductNotFoundException;
import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import java.util.List;

public class FindAllCommandHandler {

	private final ProductRepository productRepository;

	public FindAllCommandHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> handler() {
		final List<Product> products = productRepository.findAll();
		if (products.isEmpty())
			throw new ProductNotFoundException("No products found");
		return products;
	}
}
