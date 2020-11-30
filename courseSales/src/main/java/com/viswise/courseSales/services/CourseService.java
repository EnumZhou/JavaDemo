package com.viswise.courseSales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viswise.courseSales.daos.CourseDao;
import com.viswise.courseSales.models.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseDao cd;
	
	public List<Course> getAllCourses() {
		return cd.findAll();
	}
	
	
	public void addCourse(Course course) {
		
		Course c=new Course(course.getId(),course.getCourse_code(),course.getCourse_title(),
				course.getInstructor(),course.getSchedule(),course.getPrice());
		cd.save(c);
		
	}
	
}
