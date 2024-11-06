package com.challenge.ecommerce.tps.product_management.user.infrastructure;

import com.challenge.ecommerce.tps.product_management.user.domain.User;
import com.challenge.ecommerce.tps.product_management.user.domain.UserRepository;
import java.util.OptionalLong;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class UserJpaPostgresRepository implements UserRepository {

	private final UserJpaRepository userJpaRepository;

	@Override
	public OptionalLong findUserIdByEmail(final String email) {
		return OptionalLong.of(this.userJpaRepository.findUserIdByEmail(email));
	}

	@Override
	public void save(User user) {
	}
}
