package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	// Driver declaration public static so it can be used anywhere inside the project
	public static WebDriver driver;
	
	// Create a new instance of a chrome driver
	public static void initChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
}
