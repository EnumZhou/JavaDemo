package com.mercury.gemeOnlineShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.gemeOnlineShop.beans.Platform;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.services.PlatformService;

@RestController
@RequestMapping("/platforms")
public class PlatformController {
	
	@Autowired
	private PlatformService platformService;
	
	@PostMapping
	public Response save(@RequestBody Platform platform) {
		return platformService.save(platform);
	}
	
	@GetMapping
	public List<Platform> getAll() {
		return platformService.getAll();
	}

}
