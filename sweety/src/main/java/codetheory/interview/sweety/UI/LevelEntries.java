package codetheory.interview.sweety.UI;

import java.util.List;

import org.openqa.selenium.WebElement;

import codetheory.interview.sweety.UISupport.AbstractLocator;

public class LevelEntries extends AbstractLocator{
WebElement webElement;
List<WebElement> webElements;
private String TableRecentEntries_Xpath = "//*[@id='page-content-wrapper']//table/tbody";
//.//*[@id='page-content-wrapper']//table/tbody//th/following-sibling::td[1]
private String TableRecentEntriesDeleteLinks_Xpath = ".//*[@id='page-content-wrapper']//table//a";
private String AddNew_LinkText = "Add new";
private String RecordedAtYear_ID = "entry_recorded_at_1i";
private String RecordedAtMonth_ID = "entry_recorded_at_2i";
private String RecordedAtDate_ID = "entry_recorded_at_3i";
private String RecordedAtHours_ID = "entry_recorded_at_4i";
private String RecordedAtMinutes_ID = "entry_recorded_at_5i";
private String Level_ID = "entry_level";
private String LevelMeasurement_xpath ="//*[@id='entry_level']/Ancestor::div/following-sibling::div";
private String Submit_Xpath = "//*[@type='submit' and @value='Submit']";
private String Cancel_LinkText = "Cancel";





public WebElement getRecentEntries_Table() {
	webElement = getWebElement("Xpath", TableRecentEntries_Xpath);
	return webElement;
}

public List<WebElement> getRecentEntriesDeleteLinks() {
	webElements = getWebElements("Xpath", TableRecentEntriesDeleteLinks_Xpath);
	return webElements;
}

public WebElement getAddNew_LinkText() {
	webElement = getWebElement("LinkText", AddNew_LinkText);
	return webElement;
}

public WebElement getRecordedAtYear_ID() {
	webElement = getWebElement("ID", RecordedAtYear_ID);
	return webElement;
}

public WebElement getRecordedAtMonth_ID() {
	webElement = getWebElement("ID", RecordedAtMonth_ID);
	return webElement;
}

public WebElement getRecordedAtDate_ID() {
	webElement = getWebElement("ID", RecordedAtDate_ID);
	return webElement;
}

public WebElement getRecordedAtHours_ID() {
	webElement = getWebElement("ID", RecordedAtHours_ID);
	return webElement;
}

public WebElement getRecordedAtMinutes_ID() {
	webElement = getWebElement("ID", RecordedAtMinutes_ID);
	return webElement;
}

public WebElement getLevel_ID() {
	webElement = getWebElement("ID", Level_ID);
	return webElement;
}

public WebElement getLevelMeasurement_xpath() {
	webElement = getWebElement("Xpath", LevelMeasurement_xpath);
	return webElement;
}

public WebElement getSubmit_Xpath() {
	webElement = getWebElement("Xpath", Submit_Xpath);
	return webElement;
}

public WebElement getCancel_LinkText() {
	webElement = getWebElement("LinkText", Cancel_LinkText);
	return webElement;
}

}
