package codetheory.interview.sweety.UI;

import org.openqa.selenium.WebElement;

import codetheory.interview.sweety.CommonFunctions.Wait;
import codetheory.interview.sweety.UISupport.AbstractLocator;

public class CommonMenu extends AbstractLocator {
	WebElement webElement;
	private String MenuToggle_ID = "menu-toggle";
	private String Sweety_Xpath ="//*[@id='sidebar-wrapper']/ul/li[1]/a";
	private String Levels_LinkText =  "Levels";  //"//*[@id='sidebar-wrapper']/ul/li[2]/a";
	private String Reports_LinkText =   "Reports"       //"//*[@id='sidebar-wrapper']/ul/li[3]/a";
	;
	public WebElement getMenuToggle_ID() {
		webElement = getWebElement("ID", MenuToggle_ID);
		return webElement;
	}
	
	public WebElement getSweety_Xpath() {
		webElement = getWebElement("Xpath", Sweety_Xpath);
		return webElement;
	}
	
	public WebElement getLevels_Xpath() {
		webElement = getWebElement("LinkText", Levels_LinkText);
		return webElement;
	}
	
	public WebElement getReports_Xpath() {
		webElement = getWebElement("LinkText", Reports_LinkText);
		return webElement;
	}
	
	public LevelEntries navigateToLevelEntryHome(){
		getLevels_Xpath().click();
		return new LevelEntries();
	}
	
	public Reports navigateToLevelReportsHome(){
		getReports_Xpath().click();
		Wait.ThreadSleepFor(3000);
		return new Reports();
	}
	
}
