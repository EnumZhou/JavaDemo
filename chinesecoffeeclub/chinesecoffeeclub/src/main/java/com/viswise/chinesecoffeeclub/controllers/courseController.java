package com.viswise.chinesecoffeeclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viswise.chinesecoffeeclub.beans.Course;
import com.viswise.chinesecoffeeclub.services.courseServices;

@Controller
@RequestMapping(path="/courses")
public class courseController {
	@Autowired
	private courseServices cs;
	
	
	@GetMapping(path="/all")
	public List<Course> getAllCourses() {
		return cs.getAll();
	}
}
