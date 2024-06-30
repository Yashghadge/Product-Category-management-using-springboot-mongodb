package com.procat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.procat.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
