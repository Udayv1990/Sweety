package codetheory.interview.sweety.CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumFunctions {
	static Select select;
	public static Select getSelect(WebElement webElement) {
		select = new Select(webElement);
		return select;
	}
	
	public static void acceptAlert(WebDriver driver) {
//		Alert alert = new Alert.
		driver.switchTo().alert();
	}

}
