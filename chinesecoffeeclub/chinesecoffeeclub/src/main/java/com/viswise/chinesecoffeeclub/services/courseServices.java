package com.viswise.chinesecoffeeclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viswise.chinesecoffeeclub.beans.Course;
import com.viswise.chinesecoffeeclub.daos.courseDao;

@Service
public class courseServices {
	@Autowired
	private courseDao cd;
	
	public List<Course> getAll() {
		return cd.findAll();
	}
	
	public void postCourse(Course course) {
		cd.save(course);
	}
}
