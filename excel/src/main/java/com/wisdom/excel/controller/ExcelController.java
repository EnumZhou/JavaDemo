package com.wisdom.excel.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.excel.model.Course;
import com.wisdom.excel.service.CourseService;

@RestController
@RequestMapping("/api")
public class ExcelController {
	
	@Autowired
	CourseService cs;
	
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		System.out.println(cs.getCourses());
		return cs.getCourses();
	}
	
	@GetMapping("/test")
	public Course index() {
		return cs.getCourses().get(0);
	}
	
}
