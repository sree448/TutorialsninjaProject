package com.tutorialsninja.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
		
	public  Base() 
	{
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
		try 
		{
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);

	    }catch(Exception e)
		{
		e.printStackTrace();
	    }
		
		dataprop = new Properties();
		File datafile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\testdata\\testdata.properties");
		try {
		FileInputStream datafis = new FileInputStream(datafile);
		dataprop.load(datafis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public WebDriver InitializingBrowserAndOpenApllicationURL(String BrowserName) 
	{		
	
	if(BrowserName.equalsIgnoreCase("chrome")) 
	{		
	  driver = new ChromeDriver();	
		   
	}else if(BrowserName.equalsIgnoreCase("firefox"))
    {
	  driver = new FirefoxDriver();
	}else if(BrowserName.equalsIgnoreCase("edge"))
	{
	  driver = new EdgeDriver();
	}

	driver.manage().window().maximize();		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));		
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));		
	driver.get(prop.getProperty("url"));	
	return driver;
	}
}
