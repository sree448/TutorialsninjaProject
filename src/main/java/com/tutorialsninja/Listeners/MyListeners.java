package com.tutorialsninja.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;

public class MyListeners implements ITestListener{
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		
		 extentReport = ExtentReporter.generateExtentReport();
	
	}
		

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + " execusion started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		extentTest.log(Status.PASS, testName + " successfully executed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver=null;

		
		String testName = result.getName();
		
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		
		String destinationScreenshotpath = Utilities.captureScreenshot(driver, testName);
		
		extentTest.addScreenCaptureFromPath(destinationScreenshotpath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + " execusion got failed"); 
		
	} 

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + " execusion got skipped");
		
		
	}

	
	
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		String pathOFExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOFExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
  		
	}
	

}
