package com.mercury.gemeOnlineShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.gemeOnlineShop.beans.OrderProduct;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.services.OrderProductService;

@RestController
@RequestMapping("/purchases")
public class OrderProductController {
	
	@Autowired
	private OrderProductService orderProductService;
	
	@PostMapping
	public Response save(@RequestBody OrderProduct orderProduct) 
	{
		return orderProductService.save(orderProduct);
	}
	
	@GetMapping
	public List<OrderProduct> getAll() {
		return orderProductService.getAll();
	}
	
	@GetMapping("/{id}")
	public List<OrderProduct> getAllByOrderId(@PathVariable int id) {
		return orderProductService.getAllByOrderId(id);
	}
}
