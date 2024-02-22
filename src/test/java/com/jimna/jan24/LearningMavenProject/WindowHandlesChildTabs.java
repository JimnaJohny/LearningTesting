package com.jimna.jan24.LearningMavenProject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandlesChildTabs {

	EdgeDriver driver = null;
	ArrayList<String> originalTabHandles = new ArrayList<>();
	ArrayList<String> childTabHandles = new ArrayList<>();

	@BeforeMethod
	public void initialization() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");

		// Store the handle of the original tab
		originalTabHandles.add(driver.getWindowHandle());
	}

	@Test
	public void openNewTabs() {
		// Open two child tabs
		WebElement tabBtn = driver.findElement(By.id("tabButton"));
		tabBtn.click();
		WebElement tabBtn2 = driver.findElement(By.id("tabButton"));
		tabBtn2.click();

		// Store the handles of the child tabs
		Set<String> allHandles = driver.getWindowHandles();
		for (String handle : allHandles) {
			if (!originalTabHandles.contains(handle)) {
				childTabHandles.add(handle);
			}
		}

		// Switch to the first child tab
		switchToTab(childTabHandles.get(0));
		// Perform actions on the first child tab

		// Switch to the second child tab
		switchToTab(childTabHandles.get(1));
		// Perform actions on the second child tab

		// Switch back to the original tab
		switchToTab(originalTabHandles.get(0));
		// Perform actions on the original tab
	}

	// Method to switch to a specific tab
	private void switchToTab(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	@AfterMethod
	public void closing() {
		// driver.close();
	}
}
