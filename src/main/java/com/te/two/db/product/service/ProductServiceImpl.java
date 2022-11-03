package com.te.two.db.product.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.two.db.product.dto.ProductDto;
import com.te.two.db.product.entity.Product;
import com.te.two.db.product.repo.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public String addProduct(ProductDto productDto) {
		Product product=new Product();
		BeanUtils.copyProperties(productDto, product);
		productRepository.save(product);
		return "Product Added Successfully";
	}

	@Override
	public ProductDto getProduct(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow();
		ProductDto productDto=new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
	}
}
