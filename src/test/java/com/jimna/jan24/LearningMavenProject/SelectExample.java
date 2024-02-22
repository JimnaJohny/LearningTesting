package com.jimna.jan24.LearningMavenProject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectExample {
	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	public void selectTest() {

		WebElement email = driver.findElement(By.id("input-email"));
		WebElement pwd = driver.findElement(By.id("input-password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));

		email.sendKeys("mansan@gmail.com");
		pwd.sendKeys("Password1");
		loginBtn.submit();

		WebElement addressBtn = driver.findElement(By.cssSelector("#column-right>div>a:nth-of-type(4)"));
		addressBtn.click();

		WebElement newAddressBtn = driver.findElement(By.cssSelector("#content div.pull-right a"));
		newAddressBtn.click();

		WebElement country = driver.findElement(By.id("input-country"));

		Select select = new Select(country);

		// Select By Index
		select.selectByIndex(4);

		// select by Value
		select.selectByValue("13");

		// select By Visible Text
		select.selectByVisibleText("Bangladesh");
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
		}else {
			throw new NullPointerException("Webelement list is empty");
		}

		WebElement newAddressBtn = driver.findElement(By.cssSelector("#content div.pull-right a"));
		newAddressBtn.click();

		WebElement country = driver.findElement(By.id("input-country"));

		Select select = new Select(country);

		// Select By Index
		select.selectByIndex(4);

		// select by Value
		select.selectByValue("13");

		// select By Visible Text
		select.selectByVisibleText("Bangladesh");

	}

}