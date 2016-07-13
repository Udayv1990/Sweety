package codetheory.interview.sweety.UI;

import java.util.List;

import org.openqa.selenium.WebElement;

import codetheory.interview.sweety.UISupport.AbstractLocator;

public class Home extends AbstractLocator{
List<WebElement> webElements;
WebElement webElement;
private String Tabels_Xpath = ".//*[@id='page-content-wrapper']//table";
private String Welcome_Xpath = ".//*[@id='page-content-wrapper']//div[@class='col-lg-12']";

public WebElement getRecentEntries_Table() {
	webElements = getWebElements("Xpath", Tabels_Xpath);
	return webElements.get(0);
}

public WebElement getReports_Table() {
	webElements = getWebElements("Xpath", Tabels_Xpath);
	return webElements.get(1);
}

public WebElement getWelcome_Xpath() {
	webElement = getWebElement("Xpath", Welcome_Xpath);
	return webElement;
}

}
