package com.challenge.ecommerce.tps.product_management.product.infrastructure;

import com.challenge.ecommerce.tps.product_management.product.domain.Product;

public interface ProductJpaMapper {

	Product toDomain(final ProductEntity productEntity);

	ProductEntity toJpaEntity(final Product product);
}
