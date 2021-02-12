package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class PracticeXls {

	@Test
	public void read() throws Exception {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\practice\\Example.xlsx";

		FileInputStream fil = new FileInputStream(filePath);

		Workbook wb = new XSSFWorkbook(fil);
		Sheet sheet = wb.getSheet("Sheet2");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);

		String value = cell.toString();
		String value1 = sheet.getRow(0).getCell(1).toString();

		System.out.println(value);
		System.out.println(value1);

	}
}
