package com.mercury.gemeOnlineShop.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.gemeOnlineShop.beans.User;

public interface UserDao extends JpaRepository<User,Integer>{
	User findByUsername(String username);
}
