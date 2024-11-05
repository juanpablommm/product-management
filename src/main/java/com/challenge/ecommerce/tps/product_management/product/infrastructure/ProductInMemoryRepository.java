package com.challenge.ecommerce.tps.product_management.product.infrastructure;

import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductInMemoryRepository implements ProductRepository {

	private final List<Product> products = new ArrayList<>();

	@Override
	public void create(final Product product) {
		this.products.add(product);
	}

	@Override
	public List<Product> findAll() {
		return this.products;
	}

	@Override
	public List<Product> findByProductName(final String productName) {
		return this.products.stream().filter(product -> Objects.equals(productName, product.getProductName())).toList();
	}

	@Override
	public Optional<Product> findById(Long productId) {
		return this.products.stream().filter(product -> Objects.equals(product.getProductId(), productId)).findFirst();
	}
}
