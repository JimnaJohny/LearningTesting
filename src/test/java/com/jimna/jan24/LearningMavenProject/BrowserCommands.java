package com.jimna.jan24.LearningMavenProject;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrowserCommands {

	/*
	 * @Test public void firstTest() { System.setProperty("webdriver.edge.driver",
	 * "C:\\Users\\Owner\\Downloads\\edgedriver_win64 (4)\\msedgedriver.exe");
	 * 
	 * WebDriver wd = new EdgeDriver();
	 * 
	 * wd.get("https://www.google.com/");
	 * 
	 * }
	 */
	@Test
	public void loadPageInBrowser() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		EdgeDriver driver = new EdgeDriver();

		// Load the page in the browser
		driver.get("https://demoqa.com/checkbox");

	}

	@Test
	public void closeBrowser() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		EdgeDriver driver = new EdgeDriver();

		// Load the page in the browser
		driver.get("https://demoqa.com/checkbox");

		// Close the browser instance
		driver.close();

	}

	@Test
	public void getCurrentPageUrl() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		EdgeDriver driver = new EdgeDriver();

		// Load the page in the browser
		driver.get("https://demoqa.com/checkbox");

		String urlOfThePage = driver.getCurrentUrl();

		System.out.println(urlOfThePage);

	}

	@Test
	public void getTitleOfThePage() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		EdgeDriver driver = new EdgeDriver();

		// Load the page in the browser
		driver.get(
				"https://www.thestreet.com/investing/stocks/analysts-unveil-new-meta-platforms-price-targets-ahead-of-earnings");

		String titleOfThePage = driver.getTitle();

		System.out.println(titleOfThePage);

	}

}