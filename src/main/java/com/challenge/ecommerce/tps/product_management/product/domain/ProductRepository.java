package com.challenge.ecommerce.tps.product_management.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

	void create(final Product product);

	List<Product> findAll();

	List<Product> findByProductName(final String productName);

	Optional<Product> findById(final Long productId);
}
