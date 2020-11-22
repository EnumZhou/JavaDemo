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
	
	public List<Course> readCourrsesFromExcelFile(String excelFilePath) throws IOException {
	    List<Course> listCourses = new ArrayList<>();
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	 
	  
        //Create Workbook instance holding reference to excel file
	    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	    
	    //Get first/desired sheet from the workbook
	    XSSFSheet sheet=workbook.getSheetAt(0);
	    
	    // Iterator through each rows one by one
	    Iterator<Row> rowIterator = sheet.iterator();
	    
	    while (rowIterator.hasNext()) {
	    	Row row=rowIterator.next();
	    	
	    	//For Each row, iterator through all columns
	    	Iterator<Cell> cellIterator = row.cellIterator();
	    	
	    	while(cellIterator.hasNext()) {
	    		Cell cell=cellIterator.next();
	    		// check the cell type and format accordingly
	    		switch (cell.getCellType()) 
	    		{
	    			case NUMERIC:
	    				System.out.print(cell.getNumericCellValue() + "t");
                        break;
                        
	    			case STRING:
                        System.out.print(cell.getStringCellValue() + "t");
                        break;
	    				
	    		}
	    	}
	    	System.out.println();
	    }
	    
	    workbook.close();
	    inputStream.close();
	    
	    
	    return listCourses;
	}
	
	
	
	
	
}


