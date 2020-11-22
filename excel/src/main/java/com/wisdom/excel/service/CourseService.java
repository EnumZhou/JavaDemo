package com.wisdom.excel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wisdom.excel.model.Course;

@Service
public class CourseService {
	public List<Course> getCourses() {
		List<Course> courses=new ArrayList<>();
		courses.add(new Course(1234,"Java","Introduction to Java","9.00am-5.00 pm, Mon-Fri"));
		courses.add(new Course(123225,"Python","Introduction to Python","9.00am-5.00 pm, Mon-Fri"));
		
		return courses;
	}
}
