package com.challenge.ecommerce.tps.product_management.product.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Product {

	private final Long productId;
	private final String productName;
	private final String description;
	private final String urlProductImage;
	private final BigDecimal price;
	private final String brand;
	private final Boolean enabled;
	private final OffsetDateTime publishedTime;
	private final String productCode;

	public Product(Long productId, String productName, String description, String urlProductImage, BigDecimal price,
			String brand, Boolean enabled, OffsetDateTime publishedTime, String productCode) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.urlProductImage = urlProductImage;
		this.price = price;
		this.brand = brand;
		this.enabled = enabled;
		this.publishedTime = publishedTime;
		this.productCode = productCode;
	}

	public static Product forCreate(String productName, String description, String urlProductImage,
			BigDecimal BigDecimal, String brand, Boolean enabled, OffsetDateTime publishedTime) {
		return new Product(null, productName, description, urlProductImage, BigDecimal, brand, enabled, publishedTime,
				null);
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

	public BigDecimal getPrice() {
		return price;
	}

	public String getBrand() {
		return brand;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public OffsetDateTime getPublishedTime() {
		return publishedTime;
	}

	public String getProductCode() {
		return productCode;
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
				&& Objects.equals(getPrice(), product.getPrice()) && Objects.equals(getBrand(), product.getBrand())
				&& Objects.equals(getEnabled(), product.getEnabled())
				&& Objects.equals(getPublishedTime(), product.getPublishedTime())
				&& Objects.equals(getProductCode(), product.getProductCode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProductId(), getProductName(), getDescription(), getUrlProductImage(), getPrice(),
				getBrand(), getEnabled(), getPublishedTime(), getProductCode());
	}

	@Override
	public String toString() {
		return "Product{" + "productId=" + productId + ", productName='" + productName + '\'' + ", description='"
				+ description + '\'' + ", urlProductImage='" + urlProductImage + '\'' + ", price=" + price + ", brand='"
				+ brand + '\'' + ", enabled=" + enabled + ", publishedTime=" + publishedTime + ", productCode='"
				+ productCode + '\'' + '}';
	}
}
