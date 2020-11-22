package com.wisdom.excel.model;

public class Course {
	private long id;
	
	private String title;
	
	private String description;
	
	private String schedule;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(long id, String title, String description, String schedule) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.schedule = schedule;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", schedule=" + schedule
				+ "]";
	}
	
}
