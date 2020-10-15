package com.mercury.gemeOnlineShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.gemeOnlineShop.beans.User;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/username/{username}")
	public User getByUsername(@PathVariable String username){
		return userService.getUserByUsername(username);
	}
	
//	@PreAuthorize("permitAll()")
	@PostMapping
	public Response addUser(@RequestBody User user) {
		return userService.register(user);
	}
	
	@PutMapping
	public void changeUser(@RequestBody User user) {
		 userService.changePassword(user);
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public Response deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
	
}
