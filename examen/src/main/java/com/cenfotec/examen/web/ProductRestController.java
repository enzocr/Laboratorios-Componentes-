package com.cenfotec.examen.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen.domain.Product;
import com.cenfotec.examen.service.ProductService;

@RestController
public class ProductRestController {
	@Autowired
	ProductService productService;

	@GetMapping(value = "/productos")
	public List<Product> getProduct(Model model) {

		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return products;
	}

}
