package com.challenge.ecommerce.tps.product_management.product.api;

import com.challenge.ecommerce.tps.product_management.product.api.create.CreateProductRequestDto;
import com.challenge.ecommerce.tps.product_management.product.api.find.ProductResponseDto;
import com.challenge.ecommerce.tps.product_management.product.domain.Product;

public interface ProductApiMapper {

	Product toDomain(final CreateProductRequestDto createProductRequestDto);

	ProductResponseDto toResponseDto(final Product product);
}
