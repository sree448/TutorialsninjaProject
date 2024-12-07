package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	//Objects
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	public RegisterPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	
	public void enterFirstNameField(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastNameField(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	public void enterEmailAddressField(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	public void enterTelephoneField(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	public void enterPasswordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void enterPasswordConfirmField(String passwordConfirmText) {
		passwordConfirmField.sendKeys(passwordConfirmText);
	}
	
	public void selectPrivacyPolicyField( ) {
		privacyPolicyField.click();
	}
	public void clickOnContinueButton( ) {
		continueButton.click();
	}
	
	public void selectYesNewsLetterOption( ) {
		yesNewsLetterOption.click();
	}
	
	public String getDuplicateEmailWarning() {
		String duplicateEmailWarningText=duplicateEmailWarning.getText();
		return duplicateEmailWarningText;
	}
	
	public String getPrivacyPolicyWarning() {
		String privacyPolicyWarningText=privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String getFirstNameWarning() {
		String firstNameWarningText=firstNameWarning.getText();
		return firstNameWarningText;
	}
	public String getLastNameWarning() {
		String lastNameWarningText=lastNameWarning.getText();
		return lastNameWarningText;
	}
	public String getEmailWarning() {
		String emailWarningText=emailWarning.getText();
		return emailWarningText;
	}
	public String getTelephoneWarning() {
		String telephoneWarningText=telephoneWarning.getText();
		return telephoneWarningText;
	}
	public String getPasswordWarning() {
		String passwordWarningText=passwordWarning.getText();
		return passwordWarningText;
	}
	
	

}
