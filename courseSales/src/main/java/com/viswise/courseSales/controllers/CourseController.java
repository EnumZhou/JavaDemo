package com.viswise.courseSales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viswise.courseSales.models.Course;
import com.viswise.courseSales.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	CourseService cs;
	
	@GetMapping
	public List<Course> getAll() {
		return cs.getAllCourses();
	}
	
	@PostMapping
	public String addCourse(@RequestBody Course course) {
		cs.addCourse(course);
		return "Successfully added a course";
	}
}
