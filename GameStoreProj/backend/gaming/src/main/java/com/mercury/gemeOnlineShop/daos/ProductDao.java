package com.mercury.gemeOnlineShop.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.gemeOnlineShop.beans.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{
	List<Product> findAllByPlatform(String platform);
	
	
}
