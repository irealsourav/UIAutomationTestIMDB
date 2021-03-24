package com.automation.UIAutomationTest.Utilities;

import org.testng.annotations.DataProvider;

public class ListDataprovider {

	@DataProvider(name = "sortByTopMovies")
	public static Object[][] getDataFromDataproviderforsortByTopMovies() {
		return new Object[][] { { "Ranking" }, { "IMDb Rating" }, { "Release Date" }, { "Number of Ratings" },
				{ "Your Rating" } };

	}

	@DataProvider(name = "sortByWesternGenre")
	public static Object[][] getDataFromDataproviderforSortwithWesternGenre() {
		return new Object[][] { { "Popularity" }, { "User Rating" }, { "Number of Votes" }, { "US Box Office" },
				{ "Runtime" }, { "Year" }, { "Release Date" }, { "Date of Your Rating" }, { "Your Rating" },
				{ "A-Z" } };

	}
}