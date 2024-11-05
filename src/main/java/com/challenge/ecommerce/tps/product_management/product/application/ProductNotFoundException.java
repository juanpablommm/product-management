package com.challenge.ecommerce.tps.product_management.product.application;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String message) {
		super(String.format("Error the product cannot be found: %s", message));
	}

	public ProductNotFoundException(String message, Throwable cause) {
		super(String.format("Error the product cannot be found: %s", message));
	}
}
