# life-forms

This project automates the test cases for the form pages. It is written in Java and uses Selenium and JUnit.

## Getting started
To get started, just download the project and import it to eclipse. Then, right click on `src/automationFramework/FormTests.java` and select `Run As -> JUnit test`.
#### Prerequisites
* Eclipse
* Java
* Selenium
* JUnit 4

## Drivers
For now, this project implements the [Chromedriver](http://chromedriver.storage.googleapis.com/index.html) 2.40 (the latest one to this date). Chrome was chosen because it is the most popular browser in the world. It is managed on the class `utils/Driver.java`.

## Packages
The project is structured in different packages in order to be easily maintained.

### automationFramework
This package has the test cases classes.
#### BaseTest
This class is the Base test class, from which all other test classes will extend. It implements two annotations:
* `@Before`: Creates driver, maximizes window and launch the website.
* `@After`: Closes the driver
#### FormTests
This class has all the test cases and extends the BaseTest class, so the `@Before` and `@After` methods on it will execute for all test cases of this class.
### data
This package contains all the data handling classes.
#### FormAnswer
This is the object for the form answer.
#### Answers
This class instantiates objects of the type FormAnswer that will be used on our test cases.
#### ConfigFileReader
This class handles the `config.properties` file, getting data from it (see the config.properties section below).
### pageObjects
This package has all pageObjects of the projects. The pageObjects centralize all elements and methods specific to a page in order to separate it from the test classes, therefore, making it reusable.
#### BasePage
This class has elements and methods that are common to all pages, so all other pages will extend this one.
#### FormPage
This class has all elements and methods of the form page.
### utils
This package has utility (helper) classes.
#### Driver
Centralizes the driver handling.
#### Waits
Implements different types of explicit waits that are used on the project, such as `waitUntilElementIsPresent` and `waitUntilElementIsNotPresent`.
