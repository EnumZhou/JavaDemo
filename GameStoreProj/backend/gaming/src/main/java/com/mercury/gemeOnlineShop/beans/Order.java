package com.mercury.gemeOnlineShop.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
	@JoinColumn(name="USERID")
	private User user;
	
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")   
	@Column(name="PURCHASEDATE")
	private Date purchaseDate;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderProduct> purchases;
	
	
	@Column(name="STATUS")
	private String status;


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(int id, User user, Date purchaseDate, List<OrderProduct> purchases, String status) {
		super();
		this.id = id;
		this.user = user;
		this.purchaseDate = purchaseDate;
		this.purchases = purchases;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public List<OrderProduct> getPurchases() {
		return purchases;
	}


	public void setPurchases(List<OrderProduct> purchases) {
		this.purchases = purchases;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

//	@Override
//	public String toString() {
//		return "Order [id=" + id + ", user=" + user + ", purchaseDate=" + purchaseDate + ", purchases=" + purchases
//				+ "]";
//	}
	
}
