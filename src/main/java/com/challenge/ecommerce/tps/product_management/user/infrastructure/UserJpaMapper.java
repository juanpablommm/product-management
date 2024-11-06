package com.challenge.ecommerce.tps.product_management.user.infrastructure;

import com.challenge.ecommerce.tps.product_management.user.domain.User;

public interface UserJpaMapper {

	UserEntity toJpaEntity(User user);

	User toDomain(UserEntity userEntity);
}
