package com.challenge.ecommerce.tps.product_management.product.infrastructure;

import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import com.challenge.ecommerce.tps.product_management.product.domain.ProductRepository;
import com.challenge.ecommerce.tps.product_management.user.domain.UserRepository;
import com.challenge.ecommerce.tps.product_management.user.infrastructure.UserEntity;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class ProductJapPostgresRepository implements ProductRepository {

	private final ProductJpaRepository productJpaRepository;
	private final UserRepository userRepository;
	private final ProductJpaMapper productJpaMapper;

	@Transactional
	@Override
	public void create(final Product product) {
		final String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		final Long userId = this.userRepository.findUserIdByEmail(email).orElseThrow();
		final UserEntity userEntity = UserEntity.builder().userId(userId).build();
		final ProductEntity productEntity = this.productJpaMapper.toJpaEntity(product);
		productEntity.setUser(userEntity);
		productEntity.setProductCode(String.valueOf(UUID.randomUUID()));
		this.productJpaRepository.save(productEntity);
	}

	// TODO: implement pagination
	@Override
	public List<Product> findAll() {
		final List<ProductEntity> productEntities = this.productJpaRepository.findAll();
		return productEntities.stream().map(this.productJpaMapper::toDomain).toList();
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
