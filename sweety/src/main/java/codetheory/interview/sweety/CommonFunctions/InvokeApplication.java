package codetheory.interview.sweety.CommonFunctions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InvokeApplication {
public static WebDriver driver = null;

	public static void invokeBrowser() {
		String driverPath = null;
		String browserType = Config.BrowserType();
		
		switch(browserType.toLowerCase())
		{
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "ie":
				driverPath = SetFrameWorkParameters.getLibPath()+"IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", driverPath);
				driver = new InternetExplorerDriver();
				break;
			case "chrome":
				driverPath = SetFrameWorkParameters.getLibPath()+"chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver  = new ChromeDriver();
				break;
//			default:
//				driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		
	}
	
	public static WebDriver getDriver() {
		if(driver==null) invokeBrowser();
		return driver;
	}
	
	public static void openApp() {
		if(driver==null) invokeBrowser();
		driver.get(Config.getDefaultAppURL());
		Wait.ThreadSleepFor(3000);
		
		
		
	}
}
