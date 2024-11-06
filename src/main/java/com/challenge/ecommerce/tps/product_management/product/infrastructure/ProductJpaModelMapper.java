package com.challenge.ecommerce.tps.product_management.product.infrastructure;

import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.shared.infrastructure.ModelMapperFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductJpaModelMapper implements ProductJpaMapper {

	@Override
	public Product toDomain(final ProductEntity productEntity) {
		return new Product(productEntity.getProductId(), productEntity.getProductName(), productEntity.getDescription(),
				productEntity.getUrlProductImage(), productEntity.getPrice(), productEntity.getBrand(),
				productEntity.getEnabled(), productEntity.getPublishedTime(), productEntity.getProductCode());
	}

	@Override
	public ProductEntity toJpaEntity(final Product product) {
		return ModelMapperFactory.getModelMapper().map(product, ProductEntity.class);
	}
}
