package com.mercury.gemeOnlineShop.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.gemeOnlineShop.beans.Order;
import com.mercury.gemeOnlineShop.beans.OrderProduct;
import com.mercury.gemeOnlineShop.beans.Product;
import com.mercury.gemeOnlineShop.daos.OrderDao;
import com.mercury.gemeOnlineShop.daos.OrderProductDao;
import com.mercury.gemeOnlineShop.daos.ProductDao;
import com.mercury.gemeOnlineShop.http.Response;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderProductDao orderProductDao;
	

	public Response save (Order order)
	{
		try {
				List<OrderProduct> purchases = order.getPurchases();
				purchases.forEach((orderProduct) -> {
				// enrich the product object
				Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
				orderProduct.setProduct(product);
				orderProduct.setOrder(order);
			});
			order.setPurchaseDate(new Date());
			orderDao.save(order);
			return new Response(true);
		}catch(Exception e) {
			return new Response(false);
		}
	}
	
	public Response edit(Order order) {
		try {
			Order o = (Order) orderDao.findById(order.getId()).get();
			List<OrderProduct> purchasesToRemove = o.getPurchases();
			
			List<OrderProduct> purchases = order.getPurchases();
			// handled update and add products in order
			purchases.forEach((orderProduct) -> {
				Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
				orderProduct.setProduct(product);
				orderProduct.setOrder(o);
				
			});
			
			// handle remove products in order
			if(purchases.size() > 0) {
				purchasesToRemove = purchasesToRemove.stream().filter((orderProduct) -> {
					return !purchases.contains(orderProduct);
				}).collect(Collectors.toList());
			}
			
			o.setPurchases(purchases);
			orderDao.save(o);
			
			deleteOrderProducts(purchasesToRemove);	
						
			return new Response(true);
		} catch (Exception e) {
			System.out.println(e);
			return new Response(false);
		}
	}
	
	
	public Response updateStatus(Order order) {
		try {
			Order o = (Order) orderDao.findById(order.getId()).get();
			o.setStatus(order.getStatus());
			orderDao.save(o);
//			System.out.println(o);
			return new Response(true,"status updated");
		}
		catch (Exception e) {
			return new Response(false);
		}
	}
	
	public void deleteOrderProducts(List<OrderProduct> purchases) {
		orderProductDao.deleteAll(purchases);	
	}
	
	
	public Order getOrderById(Integer id) {
		return orderDao.findById(id).get();
	}
	
	public List<Order> getAll() {
		return orderDao.findAll();
	}
	
	public List<Order> getOrderByUserId(int id) {
		return orderDao.getOrdersByUserId(id);
	}
	
	public Response deleteById (int id) {
		try {
			List<OrderProduct> purchases =orderProductDao.findAllByOrderId(id);
			deleteOrderProducts(purchases);
			orderDao.deleteById(id);
			return new Response(true, "Order " +id + " is deleted");
		}catch (Exception e) {
			return new Response(false, "Order " +id +" isn't deleted");
		}
	}

}
