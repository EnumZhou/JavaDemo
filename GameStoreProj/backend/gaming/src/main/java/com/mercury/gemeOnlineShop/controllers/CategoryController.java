package com.mercury.gemeOnlineShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.gemeOnlineShop.beans.Category;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public Response save(@RequestBody Category category){
		return categoryService.save(category);
	}
	
	@GetMapping
	public List<Category> getAll() {
		return categoryService.getAll();
	}

}
