package com.challenge.ecommerce.tps.product_management.user.domain;

import java.util.Objects;

public class User {

	private final Long id;
	private final String names;
	private final String surnames;
	private final String username;
	private final String email;
	private final Boolean enabled;

	public User(Long id, String names, String surnames, String username, String email, Boolean enabled) {
		this.id = id;
		this.names = names;
		this.surnames = surnames;
		this.username = username;
		this.email = email;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public String getNames() {
		return names;
	}

	public String getSurnames() {
		return surnames;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return Objects.equals(getId(), user.getId()) && Objects.equals(getNames(), user.getNames())
				&& Objects.equals(getSurnames(), user.getSurnames())
				&& Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getEmail(), user.getEmail())
				&& Objects.equals(getEnabled(), user.getEnabled());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getNames(), getSurnames(), getUsername(), getEmail(), getEnabled());
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", names='" + names + '\'' + ", surnames='" + surnames + '\'' + ", username='"
				+ username + '\'' + ", email='" + email + '\'' + ", enabled=" + enabled + '}';
	}
}
