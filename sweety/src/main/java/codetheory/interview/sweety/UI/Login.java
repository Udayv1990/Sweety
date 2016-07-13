package codetheory.interview.sweety.UI;

import org.openqa.selenium.WebElement;

import codetheory.interview.sweety.CommonFunctions.Wait;
import codetheory.interview.sweety.UISupport.AbstractLocator;

public class Login extends AbstractLocator{
	WebElement webElement;
	
	private String Login_ID = "user_email";
	private String Password_ID = "user_password";
	private String Submit_Xpath = "//input[@type='submit' and @value='Log in']";
	
	
	public WebElement getLogin_ID() {
		webElement = getWebElement("ID", Login_ID);
		return webElement;
	}
	
	public WebElement getPassword_ID() {
		webElement = getWebElement("ID", Password_ID);
		return webElement;
	}
	
	public WebElement getSubmit_Xpath() {
		webElement = getWebElement("Xpath", Submit_Xpath);
		return webElement;
	}
	
	public Home LoginToApp(){
		getSubmit_Xpath().click();
		Wait.ThreadSleepFor(15000);
		return new Home();
	}
	
}
