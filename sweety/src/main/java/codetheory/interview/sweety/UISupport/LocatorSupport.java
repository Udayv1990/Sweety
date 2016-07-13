package codetheory.interview.sweety.UISupport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import codetheory.interview.sweety.CommonFunctions.Config;

public class LocatorSupport {
	private String Locator;
	private String LocatorValue;
	private WebDriver driver;
	
	public LocatorSupport(String Locator, String LocatorValue, WebDriver driver) {
		this.Locator = Locator;
		this.LocatorValue = LocatorValue;
		this.driver = driver;
	}
	
	public WebElement getWebElement(){
	WebElement elem = null;		
	String method = Locator.toString().toLowerCase().trim();

	driver.manage().timeouts().implicitlyWait(Config.Min_Counter(), TimeUnit.SECONDS);
	
	try {
		if (method.contentEquals("xpath"))
			elem=driver.findElement(By.xpath(LocatorValue));
		else if(method.contentEquals("css"))
			elem=driver.findElement(By.cssSelector(LocatorValue));
		else if(method.contentEquals("id"))
			elem=driver.findElement(By.id(LocatorValue));
		else if(method.contentEquals("linktext"))
			elem=driver.findElement(By.linkText(LocatorValue));
		else if(method.contentEquals("partiallinktext"))
			elem=driver.findElement(By.partialLinkText(LocatorValue));
		else if(method.contentEquals("classname"))
			elem=driver.findElement(By.className(LocatorValue));
		else if(method.contentEquals("name"))
			elem=driver.findElement(By.name(LocatorValue));
		else if(method.contentEquals("tagname"))
			elem=driver.findElement(By.tagName(LocatorValue));
		else
			elem=null;
		return elem;
	} catch(NoSuchElementException e){
		System.out.println("Element Not Fount");
	} catch (Exception e) {
		System.out.println("Exception");
	}
	return elem; 
	}
	
	public List<WebElement> getWebElements(){
		List<WebElement> elem = null;		
		String method = Locator.toString().toLowerCase().trim();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		try {
			if (method.contentEquals("xpath"))
				elem=driver.findElements(By.xpath(LocatorValue));
			else if(method.contentEquals("css"))
				elem=driver.findElements(By.cssSelector(LocatorValue));
			else if(method.contentEquals("id"))
				elem=driver.findElements(By.id(LocatorValue));
			else if(method.contentEquals("linktext"))
				elem=driver.findElements(By.linkText(LocatorValue));
			else if(method.contentEquals("partiallinktext"))
				elem=driver.findElements(By.partialLinkText(LocatorValue));
			else if(method.contentEquals("classname"))
				elem=driver.findElements(By.className(LocatorValue));
			else if(method.contentEquals("name"))
				elem=driver.findElements(By.name(LocatorValue));
			else if(method.contentEquals("tagname"))
				elem=driver.findElements(By.tagName(LocatorValue));
			else
				elem=null;
			return elem;
		} catch(NoSuchElementException e){
			System.out.println("Element Not Fount");
		} catch (Exception e) {
			System.out.println("Exception");
		}
		return elem; 
		}
	
}
