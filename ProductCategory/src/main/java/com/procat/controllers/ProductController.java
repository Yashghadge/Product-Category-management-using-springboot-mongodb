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
import com.procat.dto.ProductDto;
import com.procat.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
   @Autowired
   ProductService productService;
   @GetMapping
   public ResponseEntity<List<ProductDto>> getAllProducts() {
       List<ProductDto> products = productService.getAllProducts();
       return ResponseEntity.ok(products);
   }
   
   @PostMapping
   public ResponseEntity<ProductDto> addCategory(@RequestBody ProductDto productDto) {
       ProductDto newProduct = productService.addProduct(productDto);
       return ResponseEntity.ok(newProduct);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<ProductDto> getProductById(@PathVariable("id") String id) {
       ProductDto product = productService.getProductById(id);
       return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
   }
   
   @GetMapping("/category/{categoryId}")
   public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable("categoryId") String categoryId) {
       List<ProductDto> categories = productService.getProductsByCategoryId(categoryId);
       return categories != null ? ResponseEntity.ok(categories) : ResponseEntity.notFound().build();
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") String id,@RequestBody ProductDto productDto) {
       productDto.setId(id);
	   ProductDto updateProduct = productService.updateProduct(productDto);
       return ResponseEntity.ok(updateProduct);
   }
   
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
       productService.deleteProduct(id);
       return ResponseEntity.noContent().build();
   }
   
   
}
