package com.cenfotec.examen.web;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cenfotec.examen.domain.Product;
import com.cenfotec.examen.domain.Storage;
import com.cenfotec.examen.service.ProductService;
import com.cenfotec.examen.service.StorageService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	StorageService storageService;

	@RequestMapping("/")
	public String index(Model model) throws ParseException {
		return "index";
	}

	@RequestMapping(value = "nuevo")
	public String nuevo(Model model) throws NullPointerException {

		List<Storage> storages = storageService.findAllStorage();

		if (storages.size() == 0) {
			storageService.saveStorage(new Storage("Alajuela"));
			storageService.saveStorage(new Storage("Cartago"));
			storageService.saveStorage(new Storage("Limon"));
			storageService.saveStorage(new Storage("Heredia"));
		}

		model.addAttribute("storages", storages);
		model.addAttribute("product", new Product());

		return "viewRegistro";
	}

	@PostMapping("registroProducto")
	public String crearProducto(Product producto) {

		producto.setEntry_date(new Date());
		productService.saveProduct(producto);

		return "exito";
	}

	@GetMapping("productsEndPoint")
	public String endPoint() {
		return "viewDataTable";
	}

	@RequestMapping("listaProductos")
	public String listaProductos(Model model, @RequestParam(required = false) String idStorage) {

		List<Storage> storages = storageService.findAllStorage();

		if (storages.size() == 0) {
			storageService.saveStorage(new Storage("Alajuela"));
			storageService.saveStorage(new Storage("Cartago"));
			storageService.saveStorage(new Storage("Limon"));
			storageService.saveStorage(new Storage("Heredia"));
		}

		model.addAttribute("storages", storages);
		model.addAttribute("product", new Product());

		List<Product> products = productService.getProductsByStorage(idStorage);
		model.addAttribute("products", products);

		return "viewListado";
	}

}