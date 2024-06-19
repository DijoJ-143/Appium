package com.ust.AppiumTesting.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

			glue="classpath:com.ust.AppiumTesting.stepDefenitions",
			features = "classpath:features/",
			 plugin= {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/",
			
			"html:prettyreport/html-reports/CucmberReport.html"
		},
			 monochrome = true)

						
		
		public class TestRunner extends AbstractTestNGCucumberTests{

		}
