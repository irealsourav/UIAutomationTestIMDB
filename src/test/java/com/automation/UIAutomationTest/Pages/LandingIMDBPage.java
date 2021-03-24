package com.automation.UIAutomationTest.Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class LandingIMDBPage {

	final WebDriver driver;

	public LandingIMDBPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);

	}

	@FindBy(how = How.ID, using = "lister-sort-by-options")
	public WebElement listofsortingOptions;

	@FindBy(how = How.XPATH, using = "//td[@class='titleColumn']/a")
	public List<WebElement> sortedMovieName;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Western')]")
	public WebElement westernGenre;

	public List<WebElement> clickOnSortTitleOptions(WebDriver driver,String sortingOption)
			throws NoSuchElementException, UnexpectedTagNameException, UnsupportedOperationException {
		Select selectallSortOptions = new Select(listofsortingOptions);
		selectallSortOptions.selectByVisibleText(sortingOption);
		return sortedMovieName;

	}

	public MovieDetailsPage clickOnEachmovie(WebDriver driver, WebElement eachmovieData)
			throws StaleElementReferenceException {

		eachmovieData.click();
		return new MovieDetailsPage(driver);

	}

	public MovieWesternGenrePage clickonwesternGenrePage(WebDriver driver) throws StaleElementReferenceException {
		westernGenre.click();
		return new MovieWesternGenrePage(driver);
	}

}
