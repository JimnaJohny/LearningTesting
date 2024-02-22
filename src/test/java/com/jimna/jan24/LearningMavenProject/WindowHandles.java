
package com.jimna.jan24.LearningMavenProject;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandles {

	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/browser-windows");

		// driver.manage().window().maximize();
	}

	@Test
	public void openNewTab() {
		WebElement tabBtn = driver.findElement(By.id("tabButton"));
		tabBtn.click();
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);

		

		Set<String> allHandles = (Set<String>) driver.getWindowHandles();
		
		
		for (String handle : allHandles) {
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		WebElement headingtext = driver.findElement(By.id("sampleHeading"));
		
		System.out.println(headingtext.getText());
		
		
		driver.switchTo().window(parentHandle);


	}

	

}
