package com.ust.AppiumTesting.stepDefenitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static AndroidDriver driver;
	public ExtentReports extent;
    public ExtentTest test;
	
	@Before
	public void setup(Scenario scenario) throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
	    options.setDeviceName("DijoPhone");
	    options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
	    options.setPlatformName("Android");
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	  //Initialize the Extent reports with the HTML reporter
		String repname = "CucumberReport_-" + getTimeStamp() + "_.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//cucumberReports//" + repname);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test= extent.createTest(scenario.getName());
		
	    
	}
	
	 public static String getTimeStamp() {
			return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		}

	    @After
	    public void closeBrowser(Scenario scenario){
	        if (scenario.isFailed()) {
	           //Take the screenshot
	            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            //Add it to the report
	            test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
	            test.fail("Test is failed");
	        } else {
	            //Take the screenshot
	            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            //Add it to the report
	            test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
	            test.pass("Test passed");
	        }
	        extent.flush();
	        driver.quit();
	    }


}
