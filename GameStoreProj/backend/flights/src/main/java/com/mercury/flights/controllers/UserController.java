package com.mercury.flights.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.flights.beans.User;
import com.mercury.flights.http.Response;
import com.mercury.flights.services.UserService;

@RestController
@RequestMapping(name="/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public Response save(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}
	

}
