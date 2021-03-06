package com.wisdom.excel.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wisdom.excel.model.Course;



public class ExcelHelper {
	
	private Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case STRING:
	        return cell.getStringCellValue();
	 
	    case BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case NUMERIC:
	        return cell.getNumericCellValue();
	    }
	 
	    return null;
	}
	
	
	public List<Course> readCourrsesFromExcelFile(String excelFilePath) throws IOException {
	    List<Course> listCourses = new ArrayList<>();
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	 
        //Create Workbook instance holding reference to excel file
	    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	    
	    //Get first/desired sheet from the workbook
	    XSSFSheet sheet=workbook.getSheetAt(0);
	    
	    // Iterator through each rows one by one
	    Iterator<Row> rowIterator = sheet.iterator();
	    
	    // Skip first row with table header
	    if(rowIterator.hasNext()) {
	    	rowIterator.next();
	    }
	    
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For Each row, iterator through all columns
			Iterator<Cell> cellIterator = row.cellIterator();
			
			// Create each course;
			Course c = new Course();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 1:
					c.setId((String)getCellValue(nextCell));
				case 2:
					c.setCourse_code((String) getCellValue(nextCell));
				case 3:
					c.setCourse_title((String) getCellValue(nextCell));
				case 4:
					c.setInstructor((String) getCellValue(nextCell));
				case 5:
					c.setSchedule((String) getCellValue(nextCell));
				case 6:
					c.setPrice((String)getCellValue(nextCell));

				}
			}
			listCourses.add(c);
		}
	    
	    workbook.close();
	    inputStream.close();
	    
	    return listCourses;
	}
	
	
	
	
	
}


