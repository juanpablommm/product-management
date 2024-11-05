package com.challenge.ecommerce.tps.product_management.product.api.create;

import com.challenge.ecommerce.tps.product_management.shared.api.ValidNotEmptyField;

public record CreateProductRequestDto(@ValidNotEmptyField String productName, @ValidNotEmptyField String description,
		String urlImage) {
}
