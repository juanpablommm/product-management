package com.challenge.ecommerce.tps.product_management.product.api;

import com.challenge.ecommerce.tps.product_management.product.api.create.CreateProductRequestDto;
import com.challenge.ecommerce.tps.product_management.product.api.find.ProductResponseDto;
import com.challenge.ecommerce.tps.product_management.product.application.create.CreateProductCommandHandler;
import com.challenge.ecommerce.tps.product_management.product.application.find.FindProductCommandHandler;
import com.challenge.ecommerce.tps.product_management.product.domain.Product;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/product")
@AllArgsConstructor
public class ProductController {

	private final ProductApiMapper productApiMapper;
	private final CreateProductCommandHandler createProductCommandHandler;
	private final FindProductCommandHandler findProductCommandHandler;

	// TODO: with pagination alter
	@GetMapping(path = "/find")
	public ResponseEntity<List<ProductResponseDto>> getByProductName(@RequestParam String productName) {
		List<Product> products = this.findProductCommandHandler.handler(productName);
		return ResponseEntity.ok(products.stream().map(this.productApiMapper::toResponseDto).toList());
	}

	@PostMapping(path = "/create")
	public ResponseEntity<?> create(@RequestBody @Valid CreateProductRequestDto createProductRequestDto) {
		final Product product = this.productApiMapper.toDomain(createProductRequestDto);
		this.createProductCommandHandler.handler(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
