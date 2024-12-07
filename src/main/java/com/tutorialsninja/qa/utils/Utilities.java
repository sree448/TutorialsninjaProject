package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 10;

	
	
	public static String GenerateEmailWithTimeStamp()
	{
		Date date = new Date();
		
		String TimeStamp = date.toString().replace(" ", "_").replace(";", "_");
		
		return "sree48"+TimeStamp+"@duck.com";

	}
	
	public static Object[][] GetTestDataFromExcel(String SheetName) {
		
		
		File Excelfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\testdata\\TutorialsninjaTestData.xlsx");
		XSSFWorkbook workbook = null;

		try
		{
		FileInputStream Excelfis = new FileInputStream(Excelfile);
		
		 workbook = new XSSFWorkbook(Excelfis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(SheetName);
		
		int rows = sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0;i<rows;i++) 
		{
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype)
				{
				case STRING:
					data[i][j]= cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString ((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
		
	}
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destinationScreenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		
		System.out.println(srcScreenshot);
		System.out.println(destinationScreenshotpath);

		try {
			FileHandler.copy(srcScreenshot,new File(destinationScreenshotpath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationScreenshotpath;

	}
	
	
	

}
