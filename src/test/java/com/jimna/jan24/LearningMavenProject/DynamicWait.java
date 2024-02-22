package com.jimna.jan24.LearningMavenProject;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicWait {
	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();

		driver.get("https://account.carbonite.com/account/logon?ReturnUrl=%2f");
	}

	@Test
	public void selectTest() {

		WebElement email = driver.findElement(By.id("email"));
		WebElement pwd = driver.findElement(By.id("Password"));
		WebElement loginBtn = driver.findElement(By.id("vueloginButton"));

		email.sendKeys("mansan@it.com");
		pwd.sendKeys("Password1");
		loginBtn.submit();
		
		WebElement bannerBtn=driver.findElement(By.id("onetrust-accept-btn-handler"));
		bannerBtn.click();
		

		WebElement download = driver.findElement(By.cssSelector("#ulDesktopSideNav li:nth-of-type(5)"));
		download.click();

		WebElement addKeycodeBtn = driver.findElement(By.cssSelector("section.keycodes #btnAddKeycode"));
		addKeycodeBtn.click();

		WebElement enterKeycodeInput = driver.findElement(By.id("enter-keycode"));
		enterKeycodeInput.sendKeys("AAAAAAAAAAAAAAAAAAAA");
		
		WebElement addBtn=driver.findElement(By.id("btnAddChanges"));
		addBtn.click();
			
		
	}

	@Test
	public void diffTest() {

		WebElement email = driver.findElement(By.id("input-email"));
		WebElement pwd = driver.findElement(By.id("input-password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));

		email.sendKeys("mansan@gmail.com");
		pwd.sendKeys("Password1");
		loginBtn.submit();

		List<WebElement> addressBtn = driver.findElements(By.cssSelector("#column-right>div>a"));
		if (addressBtn.size() > 0) {
			for (int i = 0; i < addressBtn.size(); i++) {
				if (addressBtn.get(i).getText().equals("Address Book")) {
					addressBtn.get(i).click();
					break;
				}
			}
		} else {
			throw new NullPointerException("Webelement list is empty");
		}

		WebElement newAddressBtn = driver.findElement(By.cssSelector("#content div.pull-right a"));
		newAddressBtn.click();

		WebElement country = driver.findElement(By.id("input-country"));

		Select select = new Select(country);
		sleep();
		// Select By Index
		select.selectByIndex(4);
		
		sleep();

		// select by Value
		select.selectByValue("13");

		sleep();
		
		// select By Visible Text
		select.selectByVisibleText("Bangladesh");

	}

	public void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
