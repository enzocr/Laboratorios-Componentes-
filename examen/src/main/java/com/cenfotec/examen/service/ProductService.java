package com.cenfotec.examen.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.examen.domain.Product;

public interface ProductService {

	public void saveProduct(Product newProduct);

	public List<Product> getAllProducts();

	List<Product> getProductsByStorage(String id);
	
	public Optional<Product> findById(String id);
}
