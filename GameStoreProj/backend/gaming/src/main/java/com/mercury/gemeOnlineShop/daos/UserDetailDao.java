package com.mercury.gemeOnlineShop.daos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.gemeOnlineShop.beans.UserDetail;

public interface UserDetailDao extends JpaRepository<UserDetail,Integer>{
	UserDetail findByEmail(String email);
	
}
