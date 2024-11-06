package com.challenge.ecommerce.tps.product_management.user.infrastructure;

import com.challenge.ecommerce.tps.product_management.user.domain.User;
import com.challenge.ecommerce.tps.product_management.user.domain.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalLong;
import org.springframework.stereotype.Component;

@Component
public class UserInMemoryRepository implements UserRepository {

	private final List<User> users = new ArrayList<>();

	@Override
	public OptionalLong findUserIdByEmail(final String email) {
		return this.users.stream().filter(user -> Objects.equals(user.getEmail(), email)).mapToLong(User::getId)
				.findFirst();
	}

	@Override
	public void save(final User user) {
		this.users.add(user);
	}
}
