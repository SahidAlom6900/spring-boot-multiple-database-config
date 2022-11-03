package com.te.two.db.product.service;

import com.te.two.db.product.dto.ProductDto;

public interface ProductService {
	String addProduct(ProductDto productDto);
	
	ProductDto getProduct(Long productId);
}
