package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorials Test Automation Results ");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(sparkReporter);
		 Properties configProp = new Properties();
		 File configPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
		 try {
		 FileInputStream configPropFis = new FileInputStream(configPropFile);
		 configProp.load(configPropFis);
		 }catch(Throwable e){
			 e.printStackTrace();
		 }
		
		extentReport.setSystemInfo("Application url", configProp.getProperty("url"));
		extentReport.setSystemInfo("BrowserName", configProp.getProperty("BrowserName"));
		extentReport.setSystemInfo("email", configProp.getProperty("ValidEmail"));
		extentReport.setSystemInfo("password", configProp.getProperty("ValidPassword"));
		
		extentReport.setSystemInfo("Operating System", configProp.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", configProp.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version ", configProp.getProperty("java..version"));
		
		return extentReport;
		


	}

}
