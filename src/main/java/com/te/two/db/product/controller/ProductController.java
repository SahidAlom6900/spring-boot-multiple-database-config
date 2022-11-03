package com.te.two.db.product.controller;

import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.two.db.product.dto.ProductDto;
import com.te.two.db.product.response.ProductResponse;
import com.te.two.db.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("api/v1/product")
@RestController
public class ProductController {
	private final ProductService productService;

	@PostMapping
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductDto productDto) {
		return ResponseEntity.status(CREATED).body(
				ProductResponse.builder().error(Boolean.FALSE).message(productService.addProduct(productDto)).build());
	}

	@GetMapping("{productId}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId) {
		return ResponseEntity.status(FOUND).body(ProductResponse.builder().error(Boolean.FALSE)
				.message("Product Fatched Successfully").data(productService.getProduct(productId)).build());
	}
}
