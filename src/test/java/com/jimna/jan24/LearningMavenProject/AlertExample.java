package com.jimna.jan24.LearningMavenProject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/alerts");

		//driver.manage().window().maximize();
	}

	public void acceptAlert() {
		WebElement openAlertBtn = driver.findElement(By.id("alertButton"));

		// Opened the Alert Box 
		 openAlertBtn.click();

		driver.switchTo().alert().accept();
	}

	@Test
	public void acceptConfirmationAlert() {
		WebElement openAlertBtn = driver.findElement(By.id("confirmButton"));

		// Opened the Alert Box
		openAlertBtn.click();

		//accept it
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void dismissConfirmationAlert() {
		WebElement openAlertBtn = driver.findElement(By.id("confirmButton"));

		// Opened the Alert Box
		openAlertBtn.click();

		//accept it
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void promptAlert() {
		WebElement openAlertBtn = driver.findElement(By.id("promtButton"));

		openAlertBtn.click();
		Alert alert=driver.switchTo().alert();
		
		alert.sendKeys("Munna Thakur");
		
		alert.accept();
	}

}
