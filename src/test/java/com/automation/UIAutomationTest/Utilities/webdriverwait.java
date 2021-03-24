package com.automation.UIAutomationTest.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverwait {

	public void wait(WebDriver driver, long timeoutinsec) {
		new WebDriverWait(driver, timeoutinsec).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

	}


}
