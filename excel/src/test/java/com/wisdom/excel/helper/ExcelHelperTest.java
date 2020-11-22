package com.wisdom.excel.helper;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisdom.excel.model.Course;

@SpringBootTest
public class ExcelHelperTest {
	
	@Test
	void readExcelTest() throws IOException {
		String excelFilePath="Courses.xlsx";
		ExcelHelper excelHelper=new ExcelHelper();
		
		List<Course> courses=excelHelper.readCourrsesFromExcelFile(excelFilePath);
		System.out.println(courses);
	}

}
