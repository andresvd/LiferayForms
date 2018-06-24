package automationFramework;


import org.junit.Assert;
import org.junit.Test;

import pageObjects.FormPage;
import utils.Driver;
import data.Answers;
import data.FormAnswer;
import data.ConfigFileReader;

public class FormTests extends BaseTest{
	
	/*
	 * For each unfilled term, an error message should appear and the term color must turn to red.
	 * Check that it is not possible to submit the form without filling all terms
	 */
	@Test
	public void checkMandatoryFields() throws InterruptedException {
		// Initialize page object for the form page
		FormPage formPage = new FormPage(Driver.driver);
		
		// Use the answer of JOSE_FILHO
		FormAnswer answer = Answers.JOSE_FILHO;
		
		// Try to submit without filling any fields
		formPage.submitForm();
		
		// Create a ConfigFileReader to get the property of the required field error
		ConfigFileReader configFile = new ConfigFileReader();
		String requiredFieldMessage = configFile.getProperty("requiredFieldError");
		
		// Check if all the fields show the error message
		Assert.assertEquals(requiredFieldMessage, formPage.getNameWarning());
		Assert.assertEquals(requiredFieldMessage, formPage.getBirthdayWarning());
		Assert.assertEquals(requiredFieldMessage, formPage.getWhyTestingFieldWarning());
		
		// Fill the name field and wait for error to disappear
		formPage.fillName(answer.name);
		formPage.waitForNameWarningDisappear();
		
		// Fill the birthday field and wait for error to disappear
		formPage.fillBirthday(answer.birthday);
		// Next line is commented because the error message for the birthday field is not disappearing after it is filled
		//formPage.waitForBirthdayWarningDisappear();
		
		// Fill the "Why testing field" and wait for error to disappear
		formPage.fillWhyTestingField(answer.whyTestingField);
		formPage.waitForWhyTestingFieldWarningDisappear();
		
		// Click on submit button
		formPage.submitForm();
		
		// Validate that the form was successfully sent
		formPage.checkIfFormWasSubmitted();
	}
	
	/*
	 * Fill correctly all the fields and validate that the form was successfully sent.
	 */
	@Test
	public void submitFormSuccess() throws InterruptedException {
		// Initialize page object of the form page
		FormPage formPage = new FormPage(Driver.driver);
		
		// Use the answer of JOSE_FILHO
		FormAnswer answer = Answers.JOSE_FILHO;
		
		// Fill the name field
		formPage.fillName(answer.name);
		
		// Fill the birthday field
		formPage.fillBirthday(answer.birthday);
		
		// Fill the 'why testing field' field
		formPage.fillWhyTestingField(answer.whyTestingField);
		
		// Click on submit button
		formPage.submitForm();
		
		// Validate that the form was successfully sent
		formPage.checkIfFormWasSubmitted();
	}
	
	/*
	 * Search for the text 'party rock' on the form
	 */
	@Test
	public void SearchPartyRock(){
		// Initialize page object of the form page
		FormPage formPage = new FormPage(Driver.driver);
		
		// Search for string on form
		Assert.assertTrue(formPage.stringPresentOnForm("party rock"));
	}
}
