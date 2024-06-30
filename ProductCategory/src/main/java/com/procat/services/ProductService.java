package com.procat.services;

import java.util.List;

import com.procat.dto.ProductDto;

public interface ProductService {
	List<ProductDto> getAllProducts();
	List<ProductDto> getProductsByCategoryId(String categoryId);
	ProductDto getProductById(String id);
	ProductDto addProduct(ProductDto productDto);
	ProductDto updateProduct(ProductDto productDto);
	void deleteProduct(String id);
}
