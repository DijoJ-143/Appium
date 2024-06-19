package com.ust.AppiumTesting.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {

	public static AndroidDriver driver;
	private static AppiumDriverLocalService service;
	public Properties prop;

	@BeforeTest
	public void setup() throws IOException {
//APPIUM
		if (service == null) {
			AppiumServiceBuilder builder = new AppiumServiceBuilder()
					.withAppiumJS(new File("C:\\Users\\269661\\node_modules\\appium\\build\\lib\\main.js")) // Path
																											// to
																											// appium.js
					.withTimeout(Duration.ofSeconds(60)) // Increase the timeout to 60 seconds
					.usingAnyFreePort().withArgument(GeneralServerFlag.SESSION_OVERRIDE)
					.withArgument(GeneralServerFlag.LOG_LEVEL, "info");

			service = AppiumDriverLocalService.buildService(builder);
		}
		service.start();

		// properties

		System.out.println("Appium Server is Started");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\ust\\AppiumTesting\\resource\\data.properties");
		prop.load(fis);

		// ip and port
		String ipAddress = prop.getProperty("ipAddress");
		int port = service.getUrl().getPort();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(System.getProperty("AndroidDeviceName"));// emulator-5554

		// APK
		if (Boolean.parseBoolean(prop.getProperty("APK"))) {

			System.out.println("*****USING APK FILE********");
			options.setApp(System.getProperty("user.dir") + prop.getProperty("ApkPath"));
		} else {
			System.out.println("*****INBUILT APPLICATION******");
			options.setAppPackage(prop.getProperty("PackageName"));
			options.setAppActivity(prop.getProperty("Activity"));
		}

		options.setPlatformName("Android");
		driver = new AndroidDriver(new URL("http://" + ipAddress + ":" + port), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterTest
	public static void stopServer() {
		if (service != null && service.isRunning()) {
			service.stop();
			System.out.println("Appium Server is Stopped");
		}
	}

}
