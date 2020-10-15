package com.mercury.gemeOnlineShop.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDERPRODUCT")
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="QTY")
	private int qty;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
	@JoinColumn(name="ORDERID")
	private Order order;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
	@JoinColumn(name = "PRODUCTID")
	private Product product;
	

	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}

	@JsonIgnore
	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", qty=" + qty + ", order=" + order + ", product=" + product + "]";
	}

	
}
