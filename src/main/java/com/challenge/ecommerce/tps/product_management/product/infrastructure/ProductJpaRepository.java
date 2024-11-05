package com.challenge.ecommerce.tps.product_management.product.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByProductNameIgnoreCase(final String productName);
}
