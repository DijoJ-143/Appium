package com.ust.AppiumTesting.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.AppiumTesting.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculatorScaffoldPom {
	// initiallizing
	AndroidDriver driver;
	AndroidActions actions;

//Parameterized constructor

	public CalculatorScaffoldPom(AndroidDriver driver) {
		this.driver = driver;
		actions = new AndroidActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// *************Locators*************
	@AndroidFindBy(accessibility = "1")
	WebElement one;

	@AndroidFindBy(accessibility = "2")
	WebElement two;

	@AndroidFindBy(accessibility = "3")
	WebElement three;

	@AndroidFindBy(accessibility = "4")
	WebElement four;

	@AndroidFindBy(accessibility = "multiply")
	WebElement multiply;

	@AndroidFindBy(accessibility = "plus")
	WebElement plus;

	@AndroidFindBy(accessibility = "minus")
	WebElement minus;

	@AndroidFindBy(accessibility = "divide")
	WebElement divide;

	@AndroidFindBy(accessibility = "equals")
	WebElement equals;

	@FindBy(id = "com.google.android.calculator:id/result_final")
	WebElement TextField;

	@FindBy(id = "com.google.android.calculator:id/formula")
	WebElement TextField2;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='clear']")
	WebElement clear;

	// ******** Methods************

	// input particular values
	public void clickOnInputs() {
		actions.clickOnElement(one);
		actions.clickOnElement(multiply);
		actions.clickOnElement(two);
		actions.clickOnElement(plus);
		actions.clickOnElement(three);
		actions.clickOnElement(minus);
		actions.clickOnElement(four);
		actions.clickOnElement(equals);
		actions.takeADelay(3);

	}

	// Reading the
	public String getOutPut() {
		actions.takeADelay(3);
		return actions.getText_Elemnet(TextField);
	}

	// Reading data from json and  providing input

	public String clickOnNumbers(String string) {
		// TODO Auto-generated method stub
		actions.clickOnElement(clear);

		driver.findElement(AppiumBy.accessibilityId(string));
		return actions.getText_Elemnet(TextField2);

	}

	// Inputing random inputs for geting sum value
	public void inputData() {
		actions.clickOnElement(one);
		actions.clickOnElement(plus);
		actions.clickOnElement(two);
		actions.clickOnElement(plus);
		actions.clickOnElement(three);
		actions.clickOnElement(plus);
		actions.clickOnElement(two);
		actions.clickOnElement(plus);
		actions.clickOnElement(three);
		actions.takeADelay(3);

	}

	// method for clicking on equals button

	public void clickOnEquals() {

		actions.clickOnElement(equals);
		actions.takeADelay(3);

	}

}
