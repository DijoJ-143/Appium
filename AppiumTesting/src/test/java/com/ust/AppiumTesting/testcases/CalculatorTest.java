package com.ust.AppiumTesting.testcases;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.AppiumTesting.base.BaseTest;
import com.ust.AppiumTesting.dataProvider.DataProviders;
import com.ust.AppiumTesting.pom.CalculatorScaffoldPom;
import com.ust.AppiumTesting.utils.ExtentReportsListener;

@Listeners(ExtentReportsListener.class)
public class CalculatorTest extends BaseTest {

	CalculatorScaffoldPom calculator;

	// in this test trying to figure out wheather BODMAS is working perfectly or not
	@Test(priority = 0)
	public void checkWheatherBODMASisWorking() {

		calculator = new CalculatorScaffoldPom(driver);
		calculator.clickOnInputs();
		assertEquals(calculator.getOutPut(), "1");
	}

	// in this test checking whether the number entered is displayed in the
	// calculator test field or not
	@Test(priority = 1, dataProvider = "Digits", dataProviderClass = DataProviders.class, invocationCount = 3)
	public void TestIsDigitIsDisplayed(HashMap<String, String> map) {

		assertEquals(calculator.clickOnNumbers(map.get("Number1")), "2");

	}

}
