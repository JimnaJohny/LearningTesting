package com.jimna.jan24.LearningMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHoverExample {
	EdgeDriver driver = null;
	Actions actions;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/tool-tips");

		actions = new Actions(driver);

		driver.manage().window().maximize();
	}

	@Test
	public void mouseHover() {
		WebElement mouseHoverElement = driver.findElement(By.id("toolTipButton"));

		actions.moveToElement(mouseHoverElement).perform();
		
		String attributeVal=mouseHoverElement.getAttribute("aria-describedby");


		Assert.assertEquals("buttonToolTip", attributeVal);
		
	}
	
	
}
