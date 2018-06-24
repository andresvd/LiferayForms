package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.junit.Assert.*;

import utils.Waits;

public class FormPage extends BasePage{

	/*
	 * Constructor
	 */
	public FormPage(WebDriver driver) {
		super(driver);
		
		// Wait for the submit button
		Waits.waitUntilElementIsPresent(By.xpath(submitButtonXPath));
	}

	/*
	 * Element declarations
	 */
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[1]/div[1]/h1[1]")
	private WebElement formName;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[1]/div[1]/h5[1]")
	private WebElement formDescription;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]")
	private WebElement formPageTitle;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]")
	private WebElement formPageDescription;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")
	private WebElement requiredFieldsWarning;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")
	private WebElement nameQuestion;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement nameTextBox;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]")
	private WebElement birthdayQuestion;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	private WebElement birthdayTextBox;

	@FindBy (xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]")
	private WebElement whyTestingFieldQuestion;
	
	@FindBy (xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/textarea[1]")
	private WebElement whyTestingFieldTextBox;
	
	//private final String submitButtonXPath = "//button[@class='btn btn-primary lfr-ddm-form-submit pull-right']";
	private final String submitButtonXPath = "//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[2]/button[3]";
	@FindBy (xpath=submitButtonXPath)
	private WebElement submitButton;
	
	private final String informationSentTitleXPath = "//div[@id='form-wrapper']/div[1]/div[1]/div[1]/h1[1]";
	@FindBy (xpath=informationSentTitleXPath)
	private WebElement informationSentTitle;
	
	private final String informationSentDescriptionXPath = "//div[@id='form-wrapper']/div[1]/div[1]/div[1]/h5[1]";
	@FindBy (xpath=informationSentDescriptionXPath)
	private WebElement informationSentDescription;
	
	private final String fieldWarningNameXPath = "//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]";
	@FindBy (xpath=fieldWarningNameXPath)
	private WebElement fieldWarningName;
	
	private final String fieldWarningBirthdayXPath = "//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]";
	@FindBy (xpath=fieldWarningBirthdayXPath)
	private WebElement fieldWarningBirthday;
	
	private final String fieldWarningWhyTestingFieldXPath = "//div[@id='form-wrapper']/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]";
	@FindBy (xpath=fieldWarningWhyTestingFieldXPath)
	private WebElement fieldWarningWhyTestingField;
	
	@FindBy (xpath="//div[@id='form-wrapper']/form[1]")
	private WebElement form;
	/*
	 * Methods to fill the fields
	 */
	public void fillName (String name){
		nameTextBox.sendKeys(name);
	}
	
	public void fillBirthday (String birthday){
		birthdayTextBox.sendKeys(birthday);
	}
	
	public void fillWhyTestingField (String whyTestingField){
		whyTestingFieldTextBox.sendKeys(whyTestingField);
	}
	
	// Click on submit button
	public void submitForm() throws InterruptedException{
		submitButton.submit();
	}
	
	// Check if form was correctly submitted
	public void checkIfFormWasSubmitted(){
		// Get the expected messages for successfully sent form
		String successfullySentTitle = configFile.getProperty("informationSentTitle");
		String successfullySentDescription = configFile.getProperty("infromationSentDescription");
		
		// Wait for messages to appear
		Waits.waitUntilElementIsPresent(By.xpath(informationSentTitleXPath)); 
		Waits.waitUntilElementIsPresent(By.xpath(informationSentDescriptionXPath)); 
		
		// Compare the message on the page with the expected message
		Assert.assertEquals(successfullySentTitle, informationSentTitle.getText());
		Assert.assertEquals(successfullySentDescription, informationSentDescription.getText());
	}
	
	/*
	 * Get the warning messages
	 */
	
	public String getNameWarning(){
		// Wait until warning is shown
		Waits.waitUntilElementIsPresent(By.xpath(fieldWarningNameXPath));
		return fieldWarningName.getText();
	}
	
	public String getBirthdayWarning(){
		// Wait until warning is shown
		Waits.waitUntilElementIsPresent(By.xpath(fieldWarningBirthdayXPath));
		return fieldWarningBirthday.getText();
	}
	
	public String getWhyTestingFieldWarning(){
		// Wait until warning is shown
		Waits.waitUntilElementIsPresent(By.xpath(fieldWarningWhyTestingFieldXPath));
		return fieldWarningWhyTestingField.getText();
	}
	
	// Generic method to find if element is exists on the page
	private boolean elementExists(WebElement element){
		try{
			// Tries to see that the element is displayed
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e){
			// If NoSuchElementException is thrown, then the element does not exist
			return false;
		}
	}
	
	// Check if the name warning exists
	public boolean nameWarningExists(){
		return elementExists(fieldWarningName);
	}
	
	// Check if the birthday warning exists
	public boolean birthdayWarningExists(){
		return elementExists(fieldWarningBirthday);
	}
	
	// Check if the "Why testing field" warning exists
	public boolean whyTestingFieldWarningExists(){
		return elementExists(fieldWarningWhyTestingField);
	}
	
	// Check if warning disappears
	public void waitForWarningToDisappear(By by){
		Waits.waitUntilElementIsNotPresent(by);
	}
	
	// Check if name warning disappears
	public void waitForNameWarningDisappear(){
		waitForWarningToDisappear(By.xpath(fieldWarningNameXPath));
	}
	
	// Check if birthday warning disappears
	public void waitForBirthdayWarningDisappear(){
		waitForWarningToDisappear(By.xpath(fieldWarningBirthdayXPath));
	}
	
	// Check if "Why testing field" warning disappears
	public void waitForWhyTestingFieldWarningDisappear(){
		waitForWarningToDisappear(By.xpath(fieldWarningWhyTestingFieldXPath));
	}
	
	// Click on "Why testing field" field
	public void clickWhyTestingField(){
		whyTestingFieldQuestion.click();
	}
	
	// Checks if string is present on the form element
	public boolean stringPresentOnForm(String searchValue){
		// Returns true if form text contains searchValue, and false otherwise
		return form.getText().contains(searchValue);
	}
}
