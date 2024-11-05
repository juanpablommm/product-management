package com.challenge.ecommerce.tps.product_management.product.infrastructure;

import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class ProductJapPostgresRepository implements ProductRepository {

	private final ProductJpaRepository productJpaRepository;

	private final ProductJpaMapper productJpaMapper;

	@Transactional
	@Override
	public void create(final Product product) {
		final ProductEntity productEntity = this.productJpaMapper.toJpaEntity(product);
		this.productJpaRepository.save(productEntity);
	}

	// TODO: implement pagination
	@Override
	public List<Product> findAll() {
		return List.of();
	}

	@Override
	public List<Product> findByProductName(final String productName) {
		List<ProductEntity> productEntities = this.productJpaRepository.findByProductNameIgnoreCase(productName);
		return productEntities.stream().map(this.productJpaMapper::toDomain).toList();
	}

	@Override
	public Optional<Product> findById(final Long productId) {
		Optional<ProductEntity> productEntity = this.productJpaRepository.findById(productId);
		return productEntity.map(this.productJpaMapper::toDomain);
	}
}
