package com.mercury.gemeOnlineShop.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.gemeOnlineShop.beans.Category;

public interface CategoryDao extends JpaRepository<Category,Integer> {

}
