package com.jimna.jan24.LearningMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaleElementReferenceException {
	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/text-box");
	}

	@Test
	public void sendKeysToInputField() {

		WebElement userName = driver.findElement(By.id("userName"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement pAddress = driver.findElement(By.id("permanentAddress"));

		driver.navigate().refresh();

		userName = driver.findElement(By.id("userName"));
		userEmail = driver.findElement(By.id("userEmail"));
		address = driver.findElement(By.id("currentAddress"));
		pAddress = driver.findElement(By.id("permanentAddress"));

		userName.sendKeys("Manvir");
		userEmail.sendKeys("abc@gmail.com");
		address.sendKeys("Canada");
		pAddress.sendKeys("India");
	}
}
