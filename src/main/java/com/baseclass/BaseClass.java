package com.baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static WebDriver driver;

	@BeforeSuite
	public void openBrowser() {
		// Creating the object of ChromeDriver for opening the chrome browser
		driver = new ChromeDriver();
		// Maximizing the window
		driver.manage().window().maximize();
		// Providing waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Entering into the web site
		driver.get("https://testffc.nimapinfotech.com/");
	}

//	@AfterSuite
	public void closeBrowser() {
		// closing the browser window after the completion the test script
		driver.quit();
	}
}
