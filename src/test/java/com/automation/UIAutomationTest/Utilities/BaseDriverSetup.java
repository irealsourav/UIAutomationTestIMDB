package com.automation.UIAutomationTest.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriverSetup {

	public WebDriver driverSetup(String browserName) {

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}

		if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();

			return new FirefoxDriver();
		} else
			return null;
	}
}
