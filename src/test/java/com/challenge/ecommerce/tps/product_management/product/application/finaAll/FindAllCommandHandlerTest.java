package com.challenge.ecommerce.tps.product_management.product.application.finaAll;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.product_management.product.ProductMother;
import com.challenge.ecommerce.tps.product_management.product.application.ProductNotFoundException;
import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import com.challenge.ecommerce.tps.product_management.product.infrastructure.ProductInMemoryRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class FindAllCommandHandlerTest {

	private final ProductRepository productRepository = new ProductInMemoryRepository();
	private final FindAllCommandHandler findAllCommandHandler = new FindAllCommandHandler(productRepository);

	@Test
	void shouldThrowProductNotFoundExceptionWhenNoProductsFound() {
		assertThrows(ProductNotFoundException.class, this.findAllCommandHandler::handler);
	}

	@Test
	void shouldReturnProductListWhenProductsFound() {
		final ProductMother productMother = new ProductMother();
		Stream.iterate(1, n -> n + 1).limit(100).map(user -> productMother
				.withProductName(String.format("productNameByDefault%s", UUID.randomUUID())).build())
				.forEach(this.productRepository::create);
		final List<Product> productsFound = this.findAllCommandHandler.handler();
		assertFalse(productsFound.isEmpty());
		assertEquals(100, productsFound.size());
	}

}