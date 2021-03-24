package com.automation.UIAutomationTest.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MovieWesternGenrePage {

	final WebDriver driver;

	public MovieWesternGenrePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);

	}

	@FindBy(how = How.XPATH, using = "//div[@class='lister-list']/div")
	public List<WebElement> listofAllMovies;

	private WebElement getcorrectsortoption(String optionName) {
		String sortoptionname = "//div[@id='main']/div/div[2]/a[contains(text(),'" + optionName + "')]";
		return driver.findElement(By.xpath(sortoptionname));
	}

	public int clickonEachOption(String optionName) {
		getcorrectsortoption(optionName).click();
		return listofAllMovies.size();

	}

}
