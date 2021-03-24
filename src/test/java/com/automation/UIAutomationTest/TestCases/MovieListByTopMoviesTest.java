package com.automation.UIAutomationTest.TestCases;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.UIAutomationTest.Pages.LandingIMDBPage;
import com.automation.UIAutomationTest.Pages.MovieDetailsPage;
import com.automation.UIAutomationTest.Utilities.BaseDriverSetup;
import com.automation.UIAutomationTest.Utilities.ListDataprovider;
import com.automation.UIAutomationTest.Utilities.webdriverwait;

public class MovieListByTopMoviesTest {

	public WebDriver driver;
	webdriverwait wbwait;
	SoftAssert softassertion = new SoftAssert();
	LandingIMDBPage landPG;
	MovieDetailsPage mvDetPG;
	BaseDriverSetup basedriver;
	String url;

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		basedriver = new BaseDriverSetup();
		driver = basedriver.driverSetup(browser);
		wbwait = new webdriverwait();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	@Parameters("url")
	public void openbrowser(String url) {
		this.url = url;
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test(priority = 2, dataProvider = "sortByTopMovies", dataProviderClass = ListDataprovider.class)
	public void clickOnSortingoptionsForTopMovies(String sortoptionName) throws AssertionError, Exception {
		try {
			landPG = new LandingIMDBPage(driver);
			mvDetPG = new MovieDetailsPage(driver);
			wbwait.wait(driver, 40);
			List<WebElement> moviesperpage = landPG.clickOnSortTitleOptions(driver, sortoptionName);
			int totalMovieSize = moviesperpage.size();
			Assert.assertEquals(sortoptionName + " ::for size of all the movies in Genre Western is unsuccessfu", 250,
					totalMovieSize);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int i = 249; i <= totalMovieSize; i++) {

				driver.switchTo().activeElement();
				driver.switchTo().defaultContent();
				driver.findElement(By.id("styleguide-v2"));

				WebElement webelem = driver
						.findElement(By.xpath("//tbody[@class='lister-list']/tr[" + i + "]/td[2]/a"));

				js.executeScript("arguments[0].click();", webelem);
				Assert.assertTrue(sortoptionName + " ::for the movie number " + i + "is unsuccessful",
						mvDetPG.movieExsitsorNot());
				// wbwait.wait(driver, 10);
				Reporter.log("Sort by " + sortoptionName + " ::for the movie number " + i + " is successfull", true);
				js.executeScript("window.history.back();");
				// wbwait.wait(driver, 10);

			}
		} catch (AssertionError assertErr) {
			Reporter.log(assertErr.getMessage(), true);
			softassertion.fail(assertErr.getMessage());

		} catch (Exception exp) {
			Assert.fail(exp.getMessage());
			Reporter.log(exp.getMessage());
		}
	}
}
