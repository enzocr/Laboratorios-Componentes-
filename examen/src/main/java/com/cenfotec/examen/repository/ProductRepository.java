package com.cenfotec.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
