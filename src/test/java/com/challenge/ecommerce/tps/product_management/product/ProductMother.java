package com.challenge.ecommerce.tps.product_management.product;

import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class ProductMother {

	private Long productId = 1L;
	private String productName = "Default Product";
	private String description = "Default product description";
	private String urlProductImage = "http://example.com/default-image.jpg";
	private OffsetDateTime publishedTime = OffsetDateTime.now(ZoneId.of("America/Bogota"));

	public ProductMother withProductId(Long productId) {
		this.productId = productId;
		return this;
	}

	public ProductMother withProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public ProductMother withDescription(String description) {
		this.description = description;
		return this;
	}

	public ProductMother withUrlProductImage(String urlProductImage) {
		this.urlProductImage = urlProductImage;
		return this;
	}

	public ProductMother withPublishedTime(OffsetDateTime publishedTime) {
		this.publishedTime = publishedTime;
		return this;
	}

	public Product build() {
		return new Product(productId, productName, description, urlProductImage, publishedTime);
	}
}
