package com.qa.basicTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtil 
{
	
	public static Workbook book;
	public static Sheet sheet;
	

	public static String TESTDATA_SHEET_PATH = "./src/main/java/com/qa/javapgms/Book1.xlsx";

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		Object data[][] = null;
		
		try {
			File file=new File(TESTDATA_SHEET_PATH);
			FileInputStream ip = new FileInputStream(file);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			
			//to add sheet
			//book.createSheet("demo");
			
			//for giving input to excel
			
			//sheet.createRow(2).createCell(0).setCellValue("mahi");
			//sheet.createRow(2).createCell(1).setCellValue("' ");
			//FileOutputStream fos= new FileOutputStream(file);
			//book.write(fos);

			 data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}


}
