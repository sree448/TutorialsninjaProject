package com.tutorialsninja.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.SearchPage;
import com.tutorialsninja.qa.Base.Base;

public class SearchTest extends Base {
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	
	public void Setup()
	{
		driver= InitializingBrowserAndOpenApllicationURL(prop.getProperty("BrowserName"));
	}
	
	@AfterMethod
	
	public void TearDown()
	{
		driver.quit();
		
	}
	
	@Test(priority=1)
	
	public void VerifySearchWithValidProduct()  
	{ 
		HomePage homepage = new HomePage(driver);
		SearchPage searchpage = new SearchPage(driver);
		
		homepage.enterProductIntoSearchBoxField(dataprop.getProperty("ValidProduct"));
		homepage.clickOnSearchButton();
		Assert.assertTrue(searchpage.displayStatusOfValidHPProduct(), "Valid Product is not displayed");

		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("ValidProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(), "Valid Product is not displayed");
				
	}
	
	@Test(priority=2)
	
	public void VerifySearchWithInvalidProduct() 
	{
		HomePage homepage = new HomePage(driver);
		SearchPage searchpage = new SearchPage(driver);
		
		homepage.enterProductIntoSearchBoxField(dataprop.getProperty("InvalidProduct"));
		homepage.clickOnSearchButton();
		String ActualSearchMessage = searchpage.getNoProductMessage();
		Assert.assertEquals(ActualSearchMessage,dataprop.getProperty("NoProdcutTextInSearchResult"),"No product Message is not displayed");

		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("InvalidProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//String ActualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		
	}
	
	@Test(priority=3)
	
	public void VerifySearchWithouAnyProduct() 
	{
		HomePage homepage = new HomePage(driver);
		SearchPage searchpage = new SearchPage(driver);
		homepage.clickOnSearchButton();
		String ActualSearchMessage = searchpage.getNoProductMessage();
		Assert.assertEquals(ActualSearchMessage,dataprop.getProperty("NoProdcutTextInSearchResult"),"No product Message is not displayed");

		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//String ActualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		//Assert.assertEquals(ActualSearchMessage,dataprop.getProperty("NoProdcutTextInSearchResult"),"No product Message is not displayed");
	}

}


