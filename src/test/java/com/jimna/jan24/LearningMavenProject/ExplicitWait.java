package com.jimna.jan24.LearningMavenProject;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	WebDriver driver = null;
	Select select = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		// System.setProperty("webdriver.edge.driver",
		// "C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// EDGE DRIVER
		WebDriverManager.edgedriver().setup();
		 //Launch the browser instance
		driver=new EdgeDriver();

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

	@AfterMethod
	public void closing() {
		//driver.close();
	}

	@Test(priority = 1)
	public void login() {
		WebElement rightColumn = driver.findElement(By.cssSelector("#column-right>div>a:first-of-type"));
		rightColumn.click();
		WebElement emailAddress = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		emailAddress.sendKeys("jimna@gmail.com");
		password.sendKeys("jimna@1234");
		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		loginBtn.submit();
	}

	@Test /* (dependsOnMethods = "login") */
	public void addToCart() {
		WebDriverWait wait;
		wait = new WebDriverWait(driver, 30);
		WebElement laptops = wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("div.collapse>ul.nav>li:nth-of-type(2)>a")));
		laptops.click();
		WebElement laptopList = wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("div.collapse>ul.nav>li:nth-of-type(2)>div>a")));
		laptopList.click();
		WebElement selectedLaptop = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[onclick=\"cart.add('47', '1');\"]>span")));
		selectedLaptop.click();
		WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));
		addToCartBtn.click();
		WebElement viewShoppingCart = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='shopping cart']")));
		viewShoppingCart.click();
		WebElement checkoutBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Checkout']")));
		checkoutBtn.click();
		WebElement emailAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password")));
		emailAddress.sendKeys("jimna@gmail.com");
		password.sendKeys("jimna@1234");
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-login")));
		loginBtn.click();// type is not Submit

		// public void checkout()
		WebElement newAddress = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='new']")));
		newAddress.click();
		WebElement firstName = driver.findElement(By.id("input-payment-firstname"));
		WebElement lastName = driver.findElement(By.id("input-payment-lastname"));
		WebElement address1 = driver.findElement(By.id("input-payment-address-1"));
		WebElement city = driver.findElement(By.id("input-payment-city"));
		WebElement postCode = driver.findElement(By.id("input-payment-postcode"));

		// firstName.sendKeys("Jimna");
		firstName.sendKeys(RandomStringUtils.randomAlphabetic(5));
		// lastName.sendKeys("Johny");
		lastName.sendKeys(RandomStringUtils.randomAlphabetic(5));
		// address1.sendKeys("27 Third Street");
		address1.sendKeys(RandomStringUtils.randomAlphanumeric(8));
		// city.sendKeys("London");
		city.sendKeys(RandomStringUtils.randomAlphabetic(5));
		// postCode.sendKeys("M2C 1N7");
		postCode.sendKeys(RandomStringUtils.randomAlphanumeric(6));

		WebElement country = driver.findElement(By.id("input-payment-country"));
		select = new Select(country);
		select.selectByValue("38");
		WebElement state = driver.findElement(By.id("input-payment-zone"));
		select = new Select(state);
		select.selectByVisibleText("Ontario");

		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
		continueBtn.click();
		WebElement deliveryDetailsContinue = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='button-shipping-address']")));
		deliveryDetailsContinue.click();
		WebElement deliveryMethodContinue = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
		deliveryMethodContinue.click();
		WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
		checkBox.click();
		WebElement paymentMethodContinue = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
		paymentMethodContinue.click();
		WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='button-confirm']")));
		confirmBtn.click();
		WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#content>p")));
		// System.out.println(confirmationMessage.getText());

		Assert.assertEquals(confirmationMessage.getText(), "Your order has been successfully processed!");
		WebElement continuefinalBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.pull-right>a")));
		continuefinalBtn.click();
	}

}
