package com.mercury.gemeOnlineShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.gemeOnlineShop.beans.Category;
import com.mercury.gemeOnlineShop.daos.CategoryDao;
import com.mercury.gemeOnlineShop.http.Response;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public Response save(Category category) {
		try {
			categoryDao.save(category);
			return new Response(true);
		} catch (Exception e) {
			return new Response(false);
		}
	}

	public List<Category> getAll() {
		return categoryDao.findAll();
	}

}
