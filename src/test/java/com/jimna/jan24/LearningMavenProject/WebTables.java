package com.jimna.jan24.LearningMavenProject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTables {

	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
	}

	@Test
	public void webTableTest() {
		
		
		List<WebElement> rowList = driver.findElements(By.xpath("//table[@id = 'customers']//tr"));
		List<WebElement> columnList = driver.findElements(By.xpath("//table[@id = 'customers']//tr//th"));

		String beforeXpath = "//table[@id = 'customers']//tr[";
		String afterXpath = "]/td[";
		Actions action = new Actions(driver);
		for (int i = 2; i <= rowList.size(); i++) {
			for (int j = 1; j <= columnList.size(); j++) {
				WebElement element = driver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]"));
				if (element.getText().equals("Austria")) {
					action.doubleClick(element).perform();
					System.out.println(element.getText());
					break;
				}
			}
		}

	}

}
