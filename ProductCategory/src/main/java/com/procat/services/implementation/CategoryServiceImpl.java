package com.procat.services.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procat.dto.CategoryDto;
import com.procat.dto.ProductDto;
import com.procat.models.Category;
import com.procat.models.Product;
import com.procat.repositories.CategoryRepository;
import com.procat.repositories.ProductRepository;
import com.procat.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired 
	CategoryRepository categoryRepository;

	@Override
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		 List<Category> categories = categoryRepository.findAll();
	        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public CategoryDto getCategoryById(String id) {
		// TODO Auto-generated method stub
		  Optional<Category> category = categoryRepository.findById(id);
	        return category.map(this::convertToDTO).orElse(null);
	}

	@Override
	public CategoryDto addCategory(CategoryDto CategoryDto) {
		// TODO Auto-generated method stub
		Category category = convertToEntity(CategoryDto);
		Category  saveCategory = categoryRepository.save(category);
		
		return convertToDTO(saveCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category = convertToEntity(categoryDto);
		Category  updateCategory= categoryRepository.save(category);
		return convertToDTO(updateCategory);
	}

	@Override
	public void deleteCategory(String id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
		
	}
	
	private CategoryDto convertToDTO(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(category, categoryDto);
		List<ProductDto> products = productRepository.findByCategoryId(category.getId()).stream()
				.map(product ->{
					ProductDto productDto = new ProductDto();
					BeanUtils.copyProperties(product, productDto);
					return productDto;
				}).collect(Collectors.toList());
		categoryDto.setProducts(products);
		return categoryDto;
	}
	
	private Category convertToEntity(CategoryDto categoryDto) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryDto, category);
		return category;
	}
	
	

}
