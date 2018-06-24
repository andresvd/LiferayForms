package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	@FindBy (xpath="///h1[@class='ddm-form-name']")
	private WebElement formName;
	
	@FindBy (xpath="//h5[@class='ddm-form-description']")
	private WebElement formDescription;
	
	@FindBy (xpath="//h3[@class='lfr-ddm-form-page-title']")
	private WebElement formPageTitle;
	
	@FindBy (xpath="//h4[@class='lfr-ddm-form-page-description']")
	private WebElement formPageDescription;
	
	@FindBy (xpath="//label[@class='required-warning']")
	private WebElement requiredFieldsWarning;
	
	@FindBy (xpath="//div[contains(@class,'form-group')]//label[contains(@for, 'Qual…SeuNome')]")
	private WebElement nameQuestion;
	
	@FindBy (xpath="//div[contains(@class, 'input-group')]//input[contains(@id,'Qual…SeuNome')]")
	private WebElement nameTextBox;
	
	@FindBy (xpath="//div[contains(@class,'form-group')]//label[contains(@for,'Qual…ADataDoSeuNascimento')]")
	private WebElement birthdayQuestion;
	
	@FindBy (xpath="//div[contains(@data-fieldname,'Qual…ADataDoSeuNascimento')]//input[contains(@class, 'form-control')]")
	private WebElement birthdayTextBox;

	@FindBy (xpath="//div[contains(@class,'form-group')]//label[contains(@for,'PorqueVocÍIngressouNa¡reaDeTestes')]")
	private WebElement whyTestingFieldQuestion;
	
	@FindBy (xpath="//div[contains(@class, 'input-group')]/textarea[contains(@id,'PorqueVocÍIngressouNa¡reaDeTestes')]")
	private WebElement whyTestingFieldTextBox;
	
	private final String submitButtonXPath = "//button[contains(text(),'Submit')]";
	@FindBy (xpath=submitButtonXPath)
	private WebElement submitButton;
	
	private final String informationSentTitleXPath = "//h1[@class='ddm-form-name']";
	@FindBy (xpath=informationSentTitleXPath)
	private WebElement informationSentTitle;
	
	private final String informationSentDescriptionXPath = "//h5[@class='ddm-form-description']";
	@FindBy (xpath=informationSentDescriptionXPath)
	private WebElement informationSentDescription;
	
	private final String fieldWarningNameXPath = "//div[contains(@data-fieldname,'Qual…SeuNome')]//div[contains(@class,'form-feedback-item')]";
	@FindBy (xpath=fieldWarningNameXPath)
	private WebElement fieldWarningName;
	
	private final String fieldWarningBirthdayXPath = "//div[contains(@data-fieldname,'Qual…ADataDoSeuNascimento')]//div[contains(@class,'form-feedback-item')]";
	@FindBy (xpath=fieldWarningBirthdayXPath)
	private WebElement fieldWarningBirthday;
	
	private final String fieldWarningWhyTestingFieldXPath = "//div[contains(@data-fieldname,'PorqueVocÍIngressouNa¡reaDeTestes')]//div[contains(@class,'form-feedback-item')]";
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
	public void submitForm() {
		submitButton.submit();
	}
	
	// Check if form was correctly submitted
	public void checkIfFormWasSubmitted(){
		// Get the expected messages for successfully sent form
		String successfullySentTitle = configFile.getProperty("informationSentTitle");
		String successfullySentDescription = configFile.getProperty("informationSentDescription");
		
		// Wait for expected messages to appear on the title and description of the form
		Waits.waitUntilTextIsPresentInElement(By.xpath(informationSentTitleXPath), successfullySentTitle); 
		Waits.waitUntilTextIsPresentInElement(By.xpath(informationSentDescriptionXPath), successfullySentDescription); 
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
	
	// Generic method to find if element exists on the page
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
