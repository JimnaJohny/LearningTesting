package com.jimna.jan24.LearningMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OtherBasicSeleniumCommand {

	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}

	@Test
	public void clickCheckBox() {
		WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
		checkbox.click();

	}

	@Test
	public void clickRadioBtn() {
		WebElement radiobtn = driver
				.findElement(By.cssSelector("#content fieldset:last-of-type div div label:first-of-type"));
		radiobtn.click();

	}

}