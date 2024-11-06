package com.challenge.ecommerce.tps.product_management.product.api.find;

import java.math.BigDecimal;

public record ProductResponseDto(String productName, String description, String urlImage, String publishedTime,
		String brand, BigDecimal price, Boolean enabled, String productCode) {
}
