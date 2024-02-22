package com.jimna.jan24.LearningMavenProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandlesMultipleTabs {

	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");

	}

	@Test
	public void openNewTab() {
		WebElement tabBtn = driver.findElement(By.id("tabButton"));
		tabBtn.click();
		WebElement tabBtn2 = driver.findElement(By.id("tabButton"));
		tabBtn2.click();
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);

		Set<String> allHandles = (Set<String>) driver.getWindowHandles();

//		for (String handle : allHandles) {
//			if(!handle.equals(parentHandle)) {
//				driver.switchTo().window(handle);
//				break;
//			}
//		}
//		
//		WebElement headingtext = driver.findElement(By.id("sampleHeading"));
//		
//		System.out.println(headingtext.getText());
//		
//		
//		driver.switchTo().window(parentHandle);
		for (String windowHandle : allHandles) {
			String title = driver.getTitle();

			if (title.contains("This is a sample page")) {
				// Now you are on the desired tab, you can perform actions here
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

}
