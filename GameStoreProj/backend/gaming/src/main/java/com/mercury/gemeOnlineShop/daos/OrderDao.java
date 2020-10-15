package com.mercury.gemeOnlineShop.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.gemeOnlineShop.beans.Order;

public interface OrderDao extends JpaRepository<Order,Integer> {
	List<Order> getOrdersByUserId(int id);
}
