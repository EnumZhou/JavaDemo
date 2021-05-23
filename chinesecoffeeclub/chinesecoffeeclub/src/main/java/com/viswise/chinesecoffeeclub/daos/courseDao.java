package com.viswise.chinesecoffeeclub.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.viswise.chinesecoffeeclub.beans.Course;

@EnableJpaRepositories
public interface courseDao extends JpaRepository<Course, Integer> {

}
