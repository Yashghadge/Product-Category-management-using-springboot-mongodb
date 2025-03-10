package com.procat.services.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procat.dto.ProductDto;
import com.procat.models.Product;
import com.procat.repositories.ProductRepository;
import com.procat.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<ProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		  List<Product> products = productRepository.findByCategoryId(categoryId);
	        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
		
	}

	@Override
	public ProductDto getProductById(String id) {
		// TODO Auto-generated method stub
		   Optional<Product> product = productRepository.findById(id);
	        return product.map(this::convertToDTO).orElse(null);
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		Product product = convertToEntity(productDto);
		Product  savedProduct= productRepository.save(product);
		return convertToDTO(savedProduct);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		Product product = convertToEntity(productDto);
		Product  updateProduct= productRepository.save(product);
		return convertToDTO(updateProduct);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}
	
	 private ProductDto convertToDTO(Product product) {
		 ProductDto productDTO = new ProductDto();
	        BeanUtils.copyProperties(product, productDTO);
	        return productDTO;
	    }

	    private Product convertToEntity(ProductDto productDTO) {
	        Product product = new Product();
	        BeanUtils.copyProperties(productDTO, product);
	        return product;
	    }

}
