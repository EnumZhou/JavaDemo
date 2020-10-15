package com.mercury.gemeOnlineShop.beans;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "USER")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "PROFILEID")
	private UserProfile userProfile;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserDetail userDetail;

	public User() {
		super();
	}

	public User(int id) {
		super();
		this.id = id;
	}

	public User(int id, String username, String password, UserProfile userProfile, UserDetail userDetail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userProfile = userProfile;
		this.userDetail = userDetail;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userProfile=" + userProfile
				+ ", userDetail=" + userDetail + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<UserProfile> profile = new HashSet<UserProfile>();
		profile.add(this.userProfile);
		return profile;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// credential : username + password
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
