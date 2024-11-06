package com.challenge.ecommerce.tps.product_management.product.api;

import com.challenge.ecommerce.tps.product_management.product.api.create.CreateProductRequestDto;
import com.challenge.ecommerce.tps.product_management.product.api.find.ProductResponseDto;
import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class ProductApiModelMapper implements ProductApiMapper {

	@Override
	public Product toDomain(final CreateProductRequestDto createProductRequestDto) {
		final OffsetDateTime dateTimeNow = OffsetDateTime.now(ZoneId.of("America/Bogota"));
		return Product.forCreate(createProductRequestDto.productName(), createProductRequestDto.urlImage(),
				createProductRequestDto.description(), createProductRequestDto.price(), createProductRequestDto.brand(),
				Boolean.TRUE, dateTimeNow);
	}

	@Override
	public ProductResponseDto toResponseDto(final Product product) {
		final OffsetDateTime publishedTime = OffsetDateTime.now();
		final String publishedTimeFormated = publishedTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		return new ProductResponseDto(product.getProductName(), product.getDescription(), product.getUrlProductImage(),
				publishedTimeFormated, product.getBrand(), product.getPrice(), product.getEnabled(),
				product.getProductCode());
	}
}
