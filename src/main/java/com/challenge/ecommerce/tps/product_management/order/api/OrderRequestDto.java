package com.challenge.ecommerce.tps.product_management.order.api;

import java.math.BigDecimal;

public record OrderRequestDto(BigDecimal totalPrice, String productCode) {
}
