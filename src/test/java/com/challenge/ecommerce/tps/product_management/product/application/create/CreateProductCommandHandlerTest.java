package com.challenge.ecommerce.tps.product_management.product.application.create;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.product_management.product.ProductMother;
import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import com.challenge.ecommerce.tps.product_management.product.infrastructure.ProductInMemoryRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class CreateProductCommandHandlerTest {

	private final ProductRepository productRepository = new ProductInMemoryRepository();
	private final CreateProductCommandHandler createProductCommandHandler = new CreateProductCommandHandler(
			productRepository);

	@Test
	void shouldInvokeRepositoryCreateMethod() {
		final Product testProduct = new ProductMother().withProductId(1L).withProductName("Tv for default").build();
		this.createProductCommandHandler.handler(testProduct);

		final Optional<Product> product = this.productRepository.findById(1L);
		assertTrue(product.isPresent());
		assertEquals(testProduct, product.get());
	}
}