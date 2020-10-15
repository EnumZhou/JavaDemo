package com.mercury.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mercury.flights.beans.User;
import com.mercury.flights.daos.UserDao;
import com.mercury.flights.http.Response;

public class UserService {
	@Autowired
	private UserDao userDao;
	
	public Response save(User user) {
		try {
			userDao.save(user);
			return new Response(true);
		}catch(Exception e) {
			return new Response(false);
		}
	}
	
	public List<User> getAll() {
		return userDao.findAll();
	}

}
