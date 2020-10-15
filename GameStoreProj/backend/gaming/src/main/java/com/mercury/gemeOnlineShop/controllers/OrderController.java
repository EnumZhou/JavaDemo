package com.mercury.gemeOnlineShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.gemeOnlineShop.beans.Order;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.services.OrderService;
import com.sun.xml.bind.v2.util.EditDistance;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public Response save(@RequestBody Order order) {
		System.out.println(order);
		return orderService.save(order);
	}
	
	@PutMapping
	public Response updateStatus(@RequestBody Order order) {
		return orderService.updateStatus(order);
	}
	
	@GetMapping
	public List<Order> getAll() {
		return orderService.getAll();
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
	
	@GetMapping("/userId/{userId}")
	public List<Order> getOrderByUserId(@PathVariable int userId) {
		return orderService.getOrderByUserId(userId);
	}
	
	
	
	@DeleteMapping("/{id}")
	public Response deleteById(@PathVariable int id) {
		return orderService.deleteById(id);
	}
	

}
