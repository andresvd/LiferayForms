package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	// Driver declaration public static so it can be used anywhere inside the project
	public static WebDriver driver;
	
	/*
	 *  Create a new instance of a chrome driver.
	 *  For mac and linux, please replace the "chromedriver.exe" file on the project for
	 *  the driver made specifically for your operational system.
	 *  Also, replace the command to set property "chromedriver.exe" to "chromedriver"
	 */
	public static void initChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver = new ChromeDriver();
	}
}
