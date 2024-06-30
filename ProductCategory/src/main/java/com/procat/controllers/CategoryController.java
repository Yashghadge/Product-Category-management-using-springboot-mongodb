package com.procat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procat.dto.CategoryDto;
import com.procat.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> categories = categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}
	
	  @PostMapping
	    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDTO) {
	        CategoryDto newCategory = categoryService.addCategory(categoryDTO);
	        return ResponseEntity.ok(newCategory);
	    }
 
	  @GetMapping("/{id}")
	    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") String id) {
	        CategoryDto category = categoryService.getCategoryById(id);
	        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") String id, @RequestBody CategoryDto categoryDto) {
	        categoryDto.setId(id);
	        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto);
	        return ResponseEntity.ok(updatedCategory);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable("id") String id) {
	        categoryService.deleteCategory(id);
	        return ResponseEntity.noContent().build();
	    }
}
