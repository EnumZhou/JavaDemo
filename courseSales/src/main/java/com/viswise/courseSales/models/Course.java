package com.viswise.courseSales.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSES")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="COURSE_CODE")
	private String course_code;
	
	@Column(name="COURSE_TITLE")
	private String course_title;
	
	@Column(name="INSTRUCTOR")
	private String instructor;
	
	@Column(name="SCHEDULE")
	private String schedule;
	
	@Column(name="PRICE")
	private int price;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String course_code, String course_title, String instructor, String schedule, int price) {
		super();
		this.id = id;
		this.course_code = course_code;
		this.course_title = course_title;
		this.instructor = instructor;
		this.schedule = schedule;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course_code=" + course_code + ", course_title=" + course_title + ", instructor="
				+ instructor + ", schedule=" + schedule + ", price=" + price + "]";
	}
	
	
	
}
