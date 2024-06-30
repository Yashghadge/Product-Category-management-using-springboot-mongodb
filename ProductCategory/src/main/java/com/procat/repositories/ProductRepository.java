package com.procat.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.procat.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
   List<Product> findByCategoryId(String categoryId);
}
