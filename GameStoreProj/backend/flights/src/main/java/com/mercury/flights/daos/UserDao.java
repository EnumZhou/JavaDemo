package com.mercury.flights.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.flights.beans.User;

public interface UserDao extends JpaRepository<User,Integer>{

}
