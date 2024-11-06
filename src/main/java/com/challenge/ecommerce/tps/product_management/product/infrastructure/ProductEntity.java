package com.challenge.ecommerce.tps.product_management.product.infrastructure;

import com.challenge.ecommerce.tps.product_management.user.infrastructure.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "products_id")
	private Long productId;

	@Column(name = "product_name", length = 100)
	private String productName;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "brand")
	private String brand;

	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "url_product_image")
	private String urlProductImage;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = "America/Bogota")
	@Column(name = "published_time")
	private OffsetDateTime publishedTime;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(name = "productcode")
	private String productCode;
}