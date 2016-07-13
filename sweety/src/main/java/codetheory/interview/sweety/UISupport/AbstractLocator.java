package codetheory.interview.sweety.UISupport;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import codetheory.interview.sweety.CommonFunctions.InvokeApplication;

public class AbstractLocator {
	LocatorSupport objLocatorSupport;
	
	public WebElement getWebElement(String Locator, String LocatorValue){
		WebDriver driver = InvokeApplication.getDriver();
		objLocatorSupport = new LocatorSupport(Locator, LocatorValue, driver);
		return objLocatorSupport.getWebElement();
	}
	
	public List<WebElement> getWebElements(String Locator, String LocatorValue){
		WebDriver driver = InvokeApplication.getDriver();
		objLocatorSupport = new LocatorSupport(Locator, LocatorValue, driver);
		return objLocatorSupport.getWebElements();
	}

}
