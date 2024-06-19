package com.ust.AppiumTesting.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;

	public static ExtentReports createInstance() throws IOException {
		// Generate unique report name based on timestamp
		String repname = "calculatorReport-" + getTimeStamp() + "_.html";
		// Set up HTML reporter with the report name
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//" + repname);
		// Load configuration XML file for HTML reporter
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\src\\test\\resources\\extent-config.xml");
		// Create ExtentReports instance
		extent = new ExtentReports();
		// Attach HTML reporter to ExtentReports instance
		extent.attachReporter(htmlReporter);
		// Set system information
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "DIJO J");
		return extent;
	}

	// Method to generate timestamp
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}
}
