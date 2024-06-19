package com.ust.AppiumTesting.stepDefenitions;

import static org.testng.Assert.assertEquals;

import com.ust.AppiumTesting.pom.CalculatorScaffoldPom;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testSumFunctionality {
	AndroidDriver driver = Hooks.driver;
	CalculatorScaffoldPom cp;

	@Given("User eneters input values")
	public void user_eneters_input_values() {
		// Write code here that turns the phrase above into concrete actions
		cp = new CalculatorScaffoldPom(driver);
		cp.inputData();
	}

	@When("User clicks on the EqualButton")
	public void user_clicks_on_the_equal_button() {
		// Write code here that turns the phrase above into concrete actions
		cp.clickOnEquals();
	}

	@Then("User should see the sum value")
	public void user_should_see_the_sum_value() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(cp.getOutPut(), "11");
	}
}
