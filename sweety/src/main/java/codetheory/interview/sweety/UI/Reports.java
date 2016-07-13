package codetheory.interview.sweety.UI;

import org.openqa.selenium.WebElement;

import codetheory.interview.sweety.UISupport.AbstractLocator;

public class Reports extends AbstractLocator {
WebElement webElement;
private String ReportsTbl_Xpath = ".//*[@id='page-content-wrapper']//table";
private String DailyReport_LinkText = "Daily";
private String MontlyReport_LinkText = "Monthly";

public WebElement getReportsTbl_Xpath() {
	webElement = getWebElement("Xpath", ReportsTbl_Xpath);
	return webElement;
}

public WebElement getDailyReport_LinkText() {
	webElement = getWebElement("Xpath", DailyReport_LinkText);
	return webElement;
}

public WebElement getMontlyReport_LinkText() {
	webElement = getWebElement("LinkText", MontlyReport_LinkText);
	return webElement;
}



}
