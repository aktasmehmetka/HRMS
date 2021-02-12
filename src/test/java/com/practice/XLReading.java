package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public final class XLReading {

	@Test
	public void read() throws Exception {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\practice\\Hello.xlsx";

		FileInputStream fis = new FileInputStream(filePath);
		// to read excel we need to use different classes
		// Workbook wbook=HSSFWorkbook() --> 2003 xfiles
		Workbook wbook=new 	XSSFWorkbook(fis);//-->2007 files
		Sheet xlsheet=wbook.getSheet("Test");
		Row row=xlsheet.getRow(0);
		Cell cell=row.getCell(0);
		String value=cell.toString();
		
		int rows=xlsheet.getPhysicalNumberOfRows();
		int cols=xlsheet.getRow(0).getLastCellNum();
		
		System.out.println(value);
		
		String value2=xlsheet.getRow(0).getCell(1).toString();
		
		System.out.println(value2);
		System.out.println("=============all values===============");
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				String value1=xlsheet.getRow(i).getCell(j).toString();
				System.out.println(value1);
			}
		}
				
	}
}
