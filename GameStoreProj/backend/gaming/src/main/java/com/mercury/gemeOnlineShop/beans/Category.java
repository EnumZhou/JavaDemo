package com.mercury.gemeOnlineShop.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="IMAGE")
	private String image;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Category(int id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
	


	
}
