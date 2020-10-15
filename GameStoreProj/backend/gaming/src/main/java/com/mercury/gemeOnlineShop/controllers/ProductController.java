package com.mercury.gemeOnlineShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.gemeOnlineShop.beans.Product;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public Response save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@GetMapping
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/id/{id}")
	public Product getById(@PathVariable int id) {
		return productService.getById(id);
	}
	
	@PutMapping
	public Response updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@GetMapping("/plateform/{platform}")
	public List<Product> getProductsByPlatform(@PathVariable String platform) {
		return productService.getProductsByPlatform(platform);
	}
	

}
