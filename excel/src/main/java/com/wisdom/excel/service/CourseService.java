package com.wisdom.excel.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.wisdom.excel.helper.ExcelHelper;
import com.wisdom.excel.model.Course;

@Service
public class CourseService {
	public List<Course> getCourses() throws IOException {
		ExcelHelper eh=new ExcelHelper();
		
		List<Course> courses=eh.readCourrsesFromExcelFile("src/main/resources/excelFiles/Course info.xlsx");
		courses.forEach(course -> System.out.println(course));

		return courses;
	}
}
