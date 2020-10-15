package com.mercury.gemeOnlineShop.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.gemeOnlineShop.beans.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct,Integer> {
	List<OrderProduct> findAllByOrderId(int id);
}
