package com.challenge.ecommerce.tps.product_management.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT user.userId FROM UserEntity user WHERE user.email = :email")
	Long findUserIdByEmail(final String email);
}
