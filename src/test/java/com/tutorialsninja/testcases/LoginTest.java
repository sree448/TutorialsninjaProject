package com.tutorialsninja.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.qa.Base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	
	public LoginTest() {
		super();
	}
	
	
	public WebDriver driver;
	
	@BeforeMethod	
	
	public void SetUp()	
	{	
		driver = InitializingBrowserAndOpenApllicationURL(prop.getProperty("BrowserName"));
		HomePage homepage = new HomePage(driver);
		homepage.selectMyAccountDropMenu();
		homepage.selectLoginOption();
		
	/*	driver.findElement(By.xpath("//span[text()='My Account']")).click();		
		driver.findElement(By.linkText("Login")).click(); */		
		
	}
	
	@AfterMethod	
	public void TearDown()
	{
		driver.quit();
	}
	
	
	@Test(priority=1, dataProvider="ValidCredentialSupplier")
	
	public void LoginWithValidCredentials(String email,String password)
	{	
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();
		
		/*driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	    Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());*/

		AccountPage accountpage = new AccountPage(driver);
	    Assert.assertTrue(accountpage.getDisplayStatusOfEditAccountInformationOption());
	    
	  
	}
	
	@DataProvider(name="ValidCredentialSupplier")
	
	public Object[][] SuplyTestData()
	{
		Object[][] data = Utilities.GetTestDataFromExcel("Login");
		return data;
	}
	
	
	
	@Test (priority = 2)	
	public void LoginWithInvalidCredentials()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.GenerateEmailWithTimeStamp());
		loginpage.enterPassword(dataprop.getProperty("InvalidPasswrod"));
		loginpage.clickLoginButton();	
		String ActualWarningMessage = loginpage.getEmailPasswordNotMatchingMessage();
		String ExpectedWarningMessage = dataprop.getProperty("EmailorPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage));
		
		Utilities.captureScreenshot(driver, ExpectedWarningMessage);
		

		

		/*driver.findElement(By.id("input-email")).sendKeys(Utilities.GenerateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("InvalidPasswrod"));
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ExpectedWarningMessage = dataprop.getProperty("EmailorPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage));*/
		

	}
	

	@Test(priority=3)
	
	public void LoginWithValidEmailInvalidPassword()
	{		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("ValidEmail"));
		loginpage.enterPassword(dataprop.getProperty("InvalidPasswrod"));
		loginpage.clickLoginButton();	
		String ActualWarningMessage = loginpage.getEmailPasswordNotMatchingMessage();
		String ExpectedWarningMessage = dataprop.getProperty("EmailorPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage));
		
		
		
		/*driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("InvalidPasswrod"));
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ExpectedWarningMessage = dataprop.getProperty("EmailorPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage));*/
	}
	

	@Test(priority=4)
	
	public void LoginWithInvalidEmailValidPassword()
	{		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.GenerateEmailWithTimeStamp());
		loginpage.enterPassword(prop.getProperty("ValidPassword"));
		loginpage.clickLoginButton();	
		String ActualWarningMessage = loginpage.getEmailPasswordNotMatchingMessage();
		String ExpectedWarningMessage = dataprop.getProperty("EmailorPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage));
		
		
		/*driver.findElement(By.id("input-email")).sendKeys(Utilities.GenerateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ExpectedWarningMessage = dataprop.getProperty("EmailorPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage));*/
	}
	
@Test(priority=5)
	
	public void LoginWithoutCredentials()
	{		
		
	    LoginPage loginpage = new LoginPage(driver);
		loginpage.clickLoginButton();	
		String ActualWarningMessage = loginpage.getEmailPasswordNotMatchingMessage();
		String ExpectedWarningMessage = dataprop.getProperty("EmailorPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage));
		
		/*driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String ExpectedWarningMessage = dataprop.getProperty("EmailorPasswordNoMatchWarning");
		Assert.assertTrue(ActualWarningMessage.contains(ExpectedWarningMessage));*/
		
	}
	


}
