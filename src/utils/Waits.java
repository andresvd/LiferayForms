package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ConfigFileReader;

public class Waits {
	
	// Wait until element is present on the page using the default time configured on "waitTime" property
	public static void waitUntilElementIsPresent(By by){
		waitUntilElementIsPresent(by, Integer.parseInt(new ConfigFileReader().getProperty("waitTime")));
	}
	
	// Wait until element is present on the page
	public static void waitUntilElementIsPresent (By by, int seconds) {
		WebDriverWait wait = new WebDriverWait (Driver.driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	// Wait until element is NOT present on the page using the default time configured on "waitTime" property
	public static void waitUntilElementIsNotPresent(By by){
		waitUntilElementIsNotPresent(by, Integer.parseInt(new ConfigFileReader().getProperty("waitTime")));
	}
	
	// Wait until element is NOT present on the page
	public static void waitUntilElementIsNotPresent (By by, int seconds){
		WebDriverWait wait = new WebDriverWait (Driver.driver, seconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	// Wait until element has a specific text using the default time configured on "waitTime" property
	public static void waitUntilTextIsPresentInElement (By by, String text){
		waitUntilTextIsPresentInElement(by, text, Integer.parseInt(new ConfigFileReader().getProperty("waitTime")));
	}
	
	// Wait until element has a specific text
	public static void waitUntilTextIsPresentInElement (By by, String text, int seconds){
		WebDriverWait wait = new WebDriverWait (Driver.driver, seconds);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
	}
}
