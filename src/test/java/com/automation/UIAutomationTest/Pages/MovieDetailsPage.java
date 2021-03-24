package com.automation.UIAutomationTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MovieDetailsPage {

	WebDriver driver;

	public MovieDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
	}

	@FindBy(how = How.XPATH, using = "//span[@itemprop='ratingValue']")
	public WebElement listofsortingOptions;

	public Boolean movieExsitsorNot() {
		try {
			if (listofsortingOptions.getText() != "")
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;

		}

	}

	public WebDriver gobacktoLandingpagePG(WebDriver driver) {
		driver.navigate().back();
		return driver;
	}
}