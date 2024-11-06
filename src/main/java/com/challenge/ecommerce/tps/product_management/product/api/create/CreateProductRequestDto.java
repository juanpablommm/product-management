package com.challenge.ecommerce.tps.product_management.product.api.create;

import com.challenge.ecommerce.tps.product_management.shared.api.ValidNotEmptyField;
import java.math.BigDecimal;

public record CreateProductRequestDto(@ValidNotEmptyField String productName, @ValidNotEmptyField String description,
		String urlImage, @ValidNotEmptyField String brand, BigDecimal price) {
}
