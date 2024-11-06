package com.challenge.ecommerce.tps.product_management.user.domain;

import java.util.OptionalLong;

public interface UserRepository {

	OptionalLong findUserIdByEmail(final String email);

	void save(final User user);
}
