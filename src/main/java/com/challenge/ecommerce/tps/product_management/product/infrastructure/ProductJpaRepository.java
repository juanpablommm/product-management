package com.challenge.ecommerce.tps.product_management.product.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByProductNameIgnoreCase(final String productName);

	@Query(value = "SELECT product.productId FROM ProductEntity product WHERE product.productCode = :productCode")
	Long findByProductCode(final String productCode);
}
