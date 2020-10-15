package com.mercury.gemeOnlineShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.gemeOnlineShop.beans.OrderProduct;
import com.mercury.gemeOnlineShop.daos.OrderProductDao;
import com.mercury.gemeOnlineShop.http.Response;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductDao orderProductDao;
	
	public Response save(OrderProduct orderProduct) {
		try {
			orderProductDao.save(orderProduct);
			return new Response(true);
		} 
		catch (Exception e) {
			return new Response(false);
		}
	}
	
	public List<OrderProduct> getAll() {
		return orderProductDao.findAll();
	}
	
	public List<OrderProduct> getAllByOrderId(int id) {
		return orderProductDao.findAllByOrderId(id);
	}
	
}
