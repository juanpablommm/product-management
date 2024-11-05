package com.challenge.ecommerce.tps.product_management.product.application.find;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.product_management.product.ProductMother;
import com.challenge.ecommerce.tps.product_management.product.application.ProductNotFoundException;
import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import com.challenge.ecommerce.tps.product_management.product.infrastructure.ProductInMemoryRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindProductCommandHandlerTest {

	private final ProductRepository productRepository = new ProductInMemoryRepository();
	private final FindProductCommandHandler findProductCommandHandler = new FindProductCommandHandler(
			productRepository);
	private final String productNameValid = "Televisor Kalley";
	@BeforeEach
	void setUp() {

		final Product productTv65 = new ProductMother().withProductName(this.productNameValid).withDescription("65pg")
				.build();
		final Product productTv50 = new ProductMother().withProductName(this.productNameValid).withDescription("50pg")
				.build();
		this.productRepository.create(productTv50);
		this.productRepository.create(productTv65);
	}

	@Test
	void shouldReturnProductListWhenProductsFound() {
		final List<Product> productsFound = this.findProductCommandHandler.handler(this.productNameValid);
		assertFalse(productsFound.isEmpty());
		assertEquals(2, productsFound.size());
	}

	@Test
	void shouldThrowExceptionWhenNoProductsFound() {
		assertThrows(ProductNotFoundException.class, () -> findProductCommandHandler.handler("NonExistentProduct"));

	}
}
