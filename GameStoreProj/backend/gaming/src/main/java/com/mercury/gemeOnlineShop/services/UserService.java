package com.mercury.gemeOnlineShop.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercury.gemeOnlineShop.beans.User;
import com.mercury.gemeOnlineShop.beans.UserDetail;
import com.mercury.gemeOnlineShop.beans.UserProfile;
import com.mercury.gemeOnlineShop.daos.UserDao;
import com.mercury.gemeOnlineShop.daos.UserDetailDao;
import com.mercury.gemeOnlineShop.http.Response;

@Service
public class UserService {
	// @Autowired
	// private UserDao userDao;
	//
	// public Response save(User user) {
	// try {
	// userDao.save(user);
	// return new Response(true);
	// }
	// catch(Exception e) {
	// return new Response(false);
	// }
	// }
	//
	// public List<User> getAll() {
	// return userDao.findAll();
	// }
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserDetailDao userDetailDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> getAll() {
		return userDao.findAll();
	}
	

	public Response register(User user) {

		String orginPassword = user.getPassword();
		System.out.println("userService: orginPassword: " + user.getPassword());

		String hashedPassword = BCrypt.hashpw(orginPassword, BCrypt.gensalt());
		System.out.println("userService: hashedPassword: " + hashedPassword);

		user.setUserProfile(new UserProfile(1));
		user.setUsername(user.getUsername());
		user.setPassword(hashedPassword);
		System.out.println("userService: user: " + user);

		if (userDao.findByUsername(user.getUsername()) != null || orginPassword.equals("")) {
			return new Response(false,"Username Exists");
		} else {
			UserDetail ud = new UserDetail();
//            ShoppingCart sc = new ShoppingCart();
			ud.setEmail(user.getUsername());

			userDao.save(user);
			userDetailDao.save(ud);
//            shoppingCartDao.save(sc);
			return new Response(true);
		}
	}

	public void changePassword(User user) {
		
			
				User u = userDao.findByUsername(user.getUsername());
				u.setPassword(passwordEncoder.encode(user.getPassword()));
				userDao.save(u);
				
			
		
	}

	public boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
		boolean isAdmin = false;
		for (GrantedAuthority profle : profiles) {
			if (profle.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		}
		;
		return isAdmin;
	}

	public Response deleteUser(int id) {
		if (userDao.findById(id).get() != null) {
			userDao.deleteById(id);
			return new Response(true);
		} else {
			return new Response(false, "User is not found!");
		}
	}
	
	public User getUserByUsername(String username){
		return userDao.findByUsername(username);
	}
}
