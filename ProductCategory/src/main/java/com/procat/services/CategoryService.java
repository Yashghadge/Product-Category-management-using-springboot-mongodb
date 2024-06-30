package com.procat.services;

import java.util.List;

import com.procat.dto.CategoryDto;

public interface CategoryService {
	List<CategoryDto> getAllCategories();
	
	CategoryDto getCategoryById(String id);
	CategoryDto addCategory(CategoryDto CategoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto);
	void deleteCategory(String id);
}
