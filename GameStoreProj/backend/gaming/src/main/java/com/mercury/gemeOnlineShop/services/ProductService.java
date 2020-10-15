package com.mercury.gemeOnlineShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.gemeOnlineShop.beans.Product;
import com.mercury.gemeOnlineShop.daos.ProductDao;
import com.mercury.gemeOnlineShop.http.Response;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Response save(Product product) {
		try {
			productDao.save(product);
			return new Response(true);
		}
		catch(Exception e) {
			return new Response(false);
		}
	}
	
	public List<Product> getAll() {
		return productDao.findAll();
	}
	
	public Product getById(int id) {
		return productDao.findById(id).get();
	}
	
	public List<Product> getProductsByPlatform(String platform) {
		return productDao.findAllByPlatform(platform);
	}
	
	public Response updateProduct(Product p) {
		try {
			Product product=productDao.findById(p.getId()).get();
			product.setCategory(p.getCategory());
			product.setImage(p.getImage());
			product.setName(p.getName());
			product.setPlatform(p.getPlatform());
			product.setPrice(p.getPrice());
			product.setStock(p.getStock());
			productDao.save(product);
			return new Response(true,"Product is updated");
			
		}catch (Exception e) {
			// TODO: handle exception
			return new Response(false,"Product doesn't update successfully");
		}
	}
	
	public Response deleteById(int id) {
		try {
			productDao.deleteById(id);
			return new Response(true,"Product " + id +" is deleted");
		}catch(Exception e){
			return new Response(false,"Product " + id +" isn't deleted successfully");
		}
	}
	
}
