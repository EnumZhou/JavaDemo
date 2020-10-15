package com.mercury.gemeOnlineShop.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="USERPROFILE")
public class UserProfile implements GrantedAuthority {
	
	@Id
	private int id;
	
	@Column(name="TYPE")
	private String type;

	public UserProfile() {
		super();
	}
	
	public UserProfile(int id) {
		super();
		this.id=id;
	}
	
	public UserProfile(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", type=" + type + "]";
	}
	
	@Override
	public String getAuthority() {
		return type;
	}

}
