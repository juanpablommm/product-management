package com.challenge.ecommerce.tps.product_management.user.infrastructure;

import com.challenge.ecommerce.tps.product_management.user.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserModelJpaMapper implements UserJpaMapper {

	@Override
	public UserEntity toJpaEntity(User user) {
		return UserEntity.builder().names(user.getNames()).surnames(user.getSurnames()).email(user.getEmail())
				.enabled(user.getEnabled()).build();
	}

	@Override
	public User toDomain(UserEntity userEntity) {
		return new User(userEntity.getUserId(), userEntity.getNames(), userEntity.getUsername(),
				userEntity.getUsername(), userEntity.getEmail(), userEntity.getEnabled());
	}
}
