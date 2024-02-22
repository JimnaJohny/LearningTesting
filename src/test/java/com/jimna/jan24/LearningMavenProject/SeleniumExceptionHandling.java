package com.jimna.jan24.LearningMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExceptionHandling {
	WebDriver driver = null;
	Actions actions;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		// System.setProperty("webdriver.edge.driver",
		// "C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// EDGE DRIVER
		WebDriverManager.edgedriver().setup();
		// Launch the browser instance
		driver = new EdgeDriver();

		// CHROME DRIVER
//		WebDriverManager.chromedriver().setup();
//		// Launch the browser instance
//		driver = new ChromeDriver();

//		//FIREFOX DRIVER
//		WebDriverManager.firefoxdriver().setup();
//		// Launch the browser instance
//		driver= new FirefoxDriver();

		// Implicit Wait
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test 
	public void addTowishList() {
		WebDriverWait wait;
		wait = new WebDriverWait(driver, 30);

		WebElement rightColumn = driver.findElement(By.cssSelector("#column-right>div>a:first-of-type"));
		rightColumn.click();
		WebElement emailAddress = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		emailAddress.sendKeys("jimna@gmail.com");
		password.sendKeys("jimna@1234");
		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		loginBtn.submit();

		WebElement laptops = wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("div.collapse>ul.nav>li:nth-of-type(2)>a")));
		laptops.click();
		WebElement laptopList = wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("div.collapse>ul.nav>li:nth-of-type(2)>div>a")));
		laptopList.click();
		WebElement wishListIcon = wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("button[onclick=\"wishlist.add('47');\"]")));
//		actions.moveToElement(wishListIcon).perform();
//		String attributeVal=wishListIcon.getAttribute("aria-describedby");
//		Assert.assertEquals("tooltip526531", attributeVal);
		wishListIcon.click();
//		WebElement wishList=driver.findElement(By.xpath("//a[text()='wish list']"));
//		wishList.click();
		WebElement confirmationMessage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.container>div.alert-success")));
		System.out.println(confirmationMessage.getText());
		Assert.assertEquals(confirmationMessage.getText(),"Success: You have added HP LP3065 to your wish list!\r\n"
				+ "×");

	}

	@AfterMethod
	public void closing() {
		// driver.close();
	}
}
