package com.qa.practice.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	public static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(40);
	public static Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
	public static Duration WAIT_FOR_ELEMENT = Duration.ofSeconds(10);

	public void writeExcel(String sheetName, String cellvalue, int row, int col) throws Exception {

		String excelPath="C:\\Users\\Mark XLVII\\eclipse-workspace\\PracticeTest\\src\\main\\java\\com\\practice\\qa\\testData\\test\\BayutContact.xlsx";

		File file= new File(excelPath);

		FileInputStream fis= new FileInputStream(file);

		XSSFWorkbook wb= new XSSFWorkbook(fis);

		XSSFSheet sheet= wb.getSheet("C:\\Users\\Mark XLVII\\eclipse-workspace\\PracticeTest\\src\\main\\java\\com\\practice\\qa\\testData\\test\\BayutContact.xlsx");

		sheet.getRow(row).createCell( 0).setCellValue(cellvalue);

		FileOutputStream fos= new FileOutputStream(new File(excelPath));

		wb.write(fos);

		wb.close();

		fos.close();
		
	}


	public void writeDataInToExcel() throws FileNotFoundException
	{
		String excelPath="C:\\Users\\Mark XLVII\\eclipse-workspace\\PracticeTest\\src\\main\\java\\com\\practice\\qa\\testData\\test\\BayutContact.xlsx";

		File file= new File(excelPath);

		FileInputStream fis= new FileInputStream(file);
	//	XSSFWorkbook wb= new XSSFWorkbook(fis);

		//XSSFSheet sheet= wb.getSheet(file);
	}


}
