package com.viswise.courseSales.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viswise.courseSales.models.Course;

public interface CourseDao extends JpaRepository<Course,Integer> {

}
