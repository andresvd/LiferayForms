package pageObjects;

import data.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageFactory{
	
	protected WebDriver driver;
	// ConfigFileReader to read property file
    protected ConfigFileReader configFile;
	//Constructor
	public BasePage (WebDriver driver) {
		this.driver = driver;
		configFile = new ConfigFileReader();
		PageFactory.initElements(driver, this);
	}
	
	
}