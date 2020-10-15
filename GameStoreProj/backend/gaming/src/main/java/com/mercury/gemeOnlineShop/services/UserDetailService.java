package com.mercury.gemeOnlineShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.gemeOnlineShop.beans.User;
import com.mercury.gemeOnlineShop.beans.UserDetail;
import com.mercury.gemeOnlineShop.daos.UserDao;
import com.mercury.gemeOnlineShop.daos.UserDetailDao;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.http.UserDetailResponse;

@Service
public class UserDetailService {
	
	@Autowired
	private UserDetailDao userDetailDao;
	
	@Autowired
	private UserDao userDao;
	
	public Response addUserDetail(UserDetail userDetail, Authentication authentication) {
		User user = userDao.findByUsername(authentication.getName());
		userDetail.setUser(user);
		return new UserDetailResponse(true, userDetailDao.save(userDetail));
	}
	
	public Response updateUserDetail(UserDetail userDetail) {
		UserDetail ud = userDetailDao.findById(userDetail.getId()).get();
		userDetail.setUser(ud.getUser());
		ud = userDetail;
		userDetailDao.save(ud);
		return new Response(true);
	}
	
	public List<UserDetail> getAll() {
		return userDetailDao.findAll();
	}
	
	
	
}
