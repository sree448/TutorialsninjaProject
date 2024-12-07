package com.tutorialsninja.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.AccountSuccessPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.qa.Base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	public RegisterTest()
	{
		super();
	}
	
	public WebDriver driver;
	
       @AfterMethod
       public void TearDown() 
       {
    	   driver.quit();
       }
       
       @BeforeMethod

       public void SetUP() 
       {
    	   
    	   driver = InitializingBrowserAndOpenApllicationURL(prop.getProperty("BrowserName"));
    	   HomePage homepage = new HomePage(driver);
   		   homepage.selectMyAccountDropMenu();
   		   homepage.selectRegisterOption();
   		   
    	   
    	   /*driver.findElement(By.xpath("//span[text()='My Account']")).click();
    	   
    	   driver.findElement(By.linkText("Register")).click();*/
    	       	   
    	   
       }
       
       @Test(priority=1)
       public void VerifyRegesteringAccouuntWithMandatoryFields() 
       {
    	   RegisterPage registerpage = new RegisterPage(driver);
    	   registerpage.enterFirstNameField(dataprop.getProperty("FirstName"));
    	   registerpage.enterLastNameField(dataprop.getProperty("LastName"));
    	   registerpage.enterEmailAddressField(Utilities.GenerateEmailWithTimeStamp());
    	   registerpage.enterTelephoneField(dataprop.getProperty("TelephoneNumber"));
    	   registerpage.enterPasswordField(prop.getProperty("ValidPassword"));
    	   registerpage.enterPasswordConfirmField(prop.getProperty("ValidPassword"));
    	   registerpage.selectPrivacyPolicyField();
    	   registerpage.clickOnContinueButton();
    	   
    	/*   driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("FirstName"));
    	   driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("LastName"));
    	   driver.findElement(By.id("input-email")).sendKeys(Utilities.GenerateEmailWithTimeStamp());
    	   driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("TelephoneNumber"));
    	   driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
    	   driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
    	   driver.findElement(By.name("agree")).click();    	   
    	   driver.findElement(By.xpath("//input[@value='Continue']")).click();*/
    	   
    	   AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
    	   String ActualHeadingMessage = accountsuccesspage.getAccountSuccessPageHeading();
    	   
    	 /*  String ActualHeadingMessage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText(); */
    	   
    	   Assert.assertEquals(ActualHeadingMessage,dataprop.getProperty("AccountSuccessfullyCreatedHedingMessage"),"Account success page is not displayed");
    	   
       }
       
       @Test(priority=2)
       public void VerifyRegesteringAccouuntWithAllFields() 
       {
    	   RegisterPage registerpage = new RegisterPage(driver);
    	   registerpage.enterFirstNameField(dataprop.getProperty("FirstName"));
    	   registerpage.enterLastNameField(dataprop.getProperty("LastName"));
    	   registerpage.enterEmailAddressField(Utilities.GenerateEmailWithTimeStamp());
    	   registerpage.enterTelephoneField(dataprop.getProperty("TelephoneNumber"));
    	   registerpage.enterPasswordField(prop.getProperty("ValidPassword"));
    	   registerpage.enterPasswordConfirmField(prop.getProperty("ValidPassword"));
    	   registerpage.selectPrivacyPolicyField();
    	   registerpage.selectYesNewsLetterOption();
    	   registerpage.clickOnContinueButton();
    	  /* driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("FirstName"));
    	   driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("LastName"));
    	   driver.findElement(By.id("input-email")).sendKeys(Utilities.GenerateEmailWithTimeStamp());
    	   driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("TelephoneNumber"));
    	   driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
    	   driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
    	   driver.findElement(By.name("agree")).click();     	  
    	   driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();    	   
    	   driver.findElement(By.xpath("//input[@value='Continue']")).click(); */
    	   
    	   AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
    	   String ActualHeadingMessage = accountsuccesspage.getAccountSuccessPageHeading();
    	   
    	  // String ActualHeadingMessage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    	   
    	   Assert.assertEquals(ActualHeadingMessage, dataprop.getProperty("AccountSuccessfullyCreatedHedingMessage"),"Account success page is not displayed");
    	   
       }
       
       @Test(priority=3)
       public void VerifyRegesteringAccouuntWithExistingEmail() 
       {
    	   
    	   RegisterPage registerpage = new RegisterPage(driver);
    	   registerpage.enterFirstNameField(dataprop.getProperty("FirstName"));
    	   registerpage.enterLastNameField(dataprop.getProperty("LastName"));
    	   registerpage.enterEmailAddressField(prop.getProperty("ValidEmail"));
    	   registerpage.enterTelephoneField(dataprop.getProperty("TelephoneNumber"));
    	   registerpage.enterPasswordField(prop.getProperty("ValidPassword"));
    	   registerpage.enterPasswordConfirmField(prop.getProperty("ValidPassword"));
    	   registerpage.selectPrivacyPolicyField();
    	   registerpage.selectYesNewsLetterOption();
    	   registerpage.clickOnContinueButton();
    	   
    	   
    	 /*  driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("FirstName"));
    	   driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("LastName"));
    	   driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
    	   driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("TelephoneNumber"));
    	   driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
    	   driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
    	   driver.findElement(By.name("agree")).click();
    	   driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
    	   driver.findElement(By.xpath("//input[@value='Continue']")).click(); */
    	   
    	   
     	  String ActualWarningMessage = registerpage.getDuplicateEmailWarning();

    	   
    	  // String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
    	   
    	  Assert.assertTrue(ActualWarningMessage.contains(dataprop.getProperty("DuplcateEmailWarning")),"Warning Message of duplicate email is not displayed");
    	   
       }
       
       @Test(priority=4)
       public void VerifyRegesteringAccouuntWithoutDetails() 
       {
    	   RegisterPage registerpage = new RegisterPage(driver);
    	   registerpage.clickOnContinueButton();

    	
    	  //driver.findElement(By.xpath("//input[@value='Continue']")).click();
    	   
    	   //String ActualPrivacyPolicyMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
    	   String ActualPrivacyPolicyMessage = registerpage.getPrivacyPolicyWarning();
    	   Assert.assertTrue(ActualPrivacyPolicyMessage.contains(dataprop.getProperty("PrivacyPolicyWarning")),"PrivacyPolicyMessage isnot displayed");
    	   
    	  // String ActualFirstNameWarningMessage = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
    	   String ActualFirstNameWarningMessage = registerpage.getFirstNameWarning();
    	   Assert.assertEquals(ActualFirstNameWarningMessage, dataprop.getProperty("FirstNameWarning"), "First Name warning message is not diplayed");
    	   
           //String ActualLastNameWarningMessage = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
           String ActualLastNameWarningMessage = registerpage.getLastNameWarning();
    	   Assert.assertEquals(ActualLastNameWarningMessage, dataprop.getProperty("LastNameWarning"), "Last Name warning message is not diplayed");
    	   
           //String ActualEmailWarningMessage = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
           String ActualEmailWarningMessage = registerpage.getEmailWarning();
    	   Assert.assertEquals(ActualEmailWarningMessage, dataprop.getProperty("EmailWarning"), "Email warning message is not diplayed");
    	   
           //String ActualTelephoneWarningMessage = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
           String ActualTelephoneWarningMessage = registerpage.getTelephoneWarning();
    	   Assert.assertEquals(ActualTelephoneWarningMessage, dataprop.getProperty("TelephoneWarning"), "Telephone warning message is not diplayed");
    	   
    	   //String ActualPasswordWarningMessage = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
    	   String ActualPasswordWarningMessage = registerpage.getPasswordWarning();
    	   Assert.assertEquals(ActualPasswordWarningMessage, dataprop.getProperty("PassWordWarning"), "Password warning message is not diplayed");

    	   
    	   
       }

}
