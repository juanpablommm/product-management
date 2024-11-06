package com.challenge.ecommerce.tps.product_management.order.infrastructure;

import com.challenge.ecommerce.tps.product_management.product.infrastructure.ProductEntity;
import com.challenge.ecommerce.tps.product_management.user.infrastructure.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Order")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderEntity {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@Column(name = "total_amount")
	private BigDecimal totalPrice;

	@NotNull @ManyToOne()
	@JoinColumn(name = "buyer_id")
	private UserEntity buyer;

	@NotNull @OneToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;

}
