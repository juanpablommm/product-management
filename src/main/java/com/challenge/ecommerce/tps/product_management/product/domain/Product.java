package com.challenge.ecommerce.tps.product_management.product.domain;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Product {

	private final Long productId;
	private final String productName;
	private final String description;
	private final String urlProductImage;
	private final OffsetDateTime publishedTime;

	public Product(Long productId, String productName, String description, String urlProductImage,
			OffsetDateTime publishedTime) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.urlProductImage = urlProductImage;
		this.publishedTime = publishedTime;
	}

	public static Product forCreate(String productName, String description, String urlProductImage,
			OffsetDateTime publishedTime) {
		return new Product(null, productName, description, urlProductImage, publishedTime);
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getDescription() {
		return description;
	}

	public String getUrlProductImage() {
		return urlProductImage;
	}

	public OffsetDateTime getPublishedTime() {
		return publishedTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product) o;
		return Objects.equals(getProductId(), product.getProductId())
				&& Objects.equals(getProductName(), product.getProductName())
				&& Objects.equals(getDescription(), product.getDescription())
				&& Objects.equals(getUrlProductImage(), product.getUrlProductImage())
				&& Objects.equals(getPublishedTime(), product.getPublishedTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProductId(), getProductName(), getDescription(), getUrlProductImage(),
				getPublishedTime());
	}

	@Override
	public String toString() {
		return "Product{" + "productId=" + productId + ", productName='" + productName + '\'' + ", description='"
				+ description + '\'' + ", urlProductImage='" + urlProductImage + '\'' + ", publishedTime="
				+ publishedTime + '}';
	}
}
