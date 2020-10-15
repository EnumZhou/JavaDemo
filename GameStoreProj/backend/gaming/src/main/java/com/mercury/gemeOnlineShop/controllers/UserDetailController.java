package com.mercury.gemeOnlineShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.gemeOnlineShop.beans.UserDetail;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.services.UserDetailService;

@RestController
@RequestMapping("/user-details")
public class UserDetailController {
	@Autowired
	private UserDetailService userDetailService;
	
	@PostMapping
	public Response postUserDetails(@RequestBody UserDetail userDetail,Authentication authentication) {
		return userDetailService.addUserDetail(userDetail,authentication);
	}
	
	@PutMapping
	public Response putUserDetails(@RequestBody UserDetail userDetail) {
		return userDetailService.updateUserDetail(userDetail);
	}
	
	@GetMapping
	public List<UserDetail> getAll() {
		return userDetailService.getAll();
	}
	
}
