package com.viswise.chinesecoffeeclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viswise.chinesecoffeeclub.beans.Course;
import com.viswise.chinesecoffeeclub.services.courseServices;

@RestController
@RequestMapping(path="/course")
public class courseController {
	@Autowired
	private courseServices cs;
	
	
	@GetMapping(path="/all")
	public List<Course> getAllCourses() {
		return cs.getAll();
	}
	
	@PostMapping("/postcourse")
	public void postCourse(@RequestBody Course course) {
		cs.postCourse(course);
	}
}
