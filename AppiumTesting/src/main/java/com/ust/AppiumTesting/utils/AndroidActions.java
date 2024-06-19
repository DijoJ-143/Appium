package com.ust.AppiumTesting.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class AndroidActions {

	static AndroidDriver driver;

	public AndroidActions(AndroidDriver driver) {

		this.driver = driver;
	}

	//delay function 
	public static void takeADelay(int i) {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Click on an particular element
	public void clickOnElement(WebElement elem) {
		takeADelay(2);
		elem.click();
		takeADelay(2);
	}

	public String getText_Elemnet(WebElement elem) {

		takeADelay(2);
		return elem.getText();

	}

	// screenshot
	public static void takeScreenshots(String filepath) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Json reading
	public static List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		// conver json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

}
