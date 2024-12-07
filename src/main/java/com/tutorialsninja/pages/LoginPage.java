package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	//Objects
	@FindBy(id="input-email")
	private WebElement emailAddressField ;
	@FindBy(id="input-password")
	private WebElement passwordAddressField;
	@FindBy(xpath="//input[@value=\"Login\"]")
	private WebElement loginButton;
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	//Actions
	
	public void enterEmailAddress(String email) {
		emailAddressField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordAddressField.sendKeys(password);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	public String getEmailPasswordNotMatchingMessage() {
		String warningText=emailPasswordNotMatchingMessage.getText();
		return warningText;
	}

}
