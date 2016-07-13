package codetheory.interview.sweety.CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public static void ThreadSleepFor(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void WaitTillPageLoad(WebElement element) {
		WebDriverWait wait = new WebDriverWait(InvokeApplication.getDriver(), Config.Normal_Counter());
			wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void WaitTillAlertPresent() {
		WebDriverWait wait = new WebDriverWait(InvokeApplication.getDriver(), Config.Normal_Counter());
			wait.until(ExpectedConditions.alertIsPresent());
	}
}
