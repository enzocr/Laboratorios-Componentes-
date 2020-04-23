package com.cenfotec.examen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen.domain.Product;
import com.cenfotec.examen.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepo;

	@Override
	public void saveProduct(Product newProduct) {
		productRepo.save(newProduct);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> getProductsByStorage(String id) {
		List<Product> products = getAllProducts();
		List<Product> productsMatch = new ArrayList<Product>();
		for (Product p : products) {
			if (p.getId_storage().equals(id)) {
				productsMatch.add(p);
			}
		}
		return productsMatch;
	}

	@Override
	public Optional<Product> findById(String id) {
		Optional<Product> product = productRepo.findById(id);
		return product;
	}

}