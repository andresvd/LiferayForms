package automationFramework;

import org.junit.After;
import org.junit.Before;

import utils.Driver;
import data.ConfigFileReader;

public class BaseTest {
	@Before
	public void setup() {
		
		// Create Chrome driver
		Driver.initChromeDriver();

		// Maximize window
		Driver.driver.manage().window().maximize();

		//Launch the Liferay Forms Website
		Driver.driver.get(new ConfigFileReader().getProperty("url"));
	}
	
	@After
	public void teardown() {
		// Close the browser
		Driver.driver.quit();
	}
}
