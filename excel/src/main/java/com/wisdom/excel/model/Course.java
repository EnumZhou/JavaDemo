package com.wisdom.excel.model;

public class Course {
	private String id;
	private String course_code;
	private String course_title;
	private String instructor;
	private String schedule;
	private String price;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String id, String course_code, String course_title, String instructor, String schedule,
			String price) {
		super();
		this.id = id;
		this.course_code = course_code;
		this.course_title = course_title;
		this.instructor = instructor;
		this.schedule = schedule;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", course_code=" + course_code + ", course_title=" + course_title + ", instructor="
				+ instructor + ", schedule=" + schedule + ", price=" + price + "]";
	}
	
	
	
}
