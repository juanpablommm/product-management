package com.challenge.ecommerce.tps.product_management.product.application.find;

import com.challenge.ecommerce.tps.product_management.product.application.ProductNotFoundException;
import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import java.util.List;

public class FindProductCommandHandler {

	private final ProductRepository productRepository;

	public FindProductCommandHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> handler(final String productName) {
		List<Product> products = this.productRepository.findByProductName(productName);
		if (products.isEmpty())
			throw new ProductNotFoundException("No products found");
		return products;
	}
}
