package com.jimna.jan24.LearningMavenProject;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTestingAssignment {
	EdgeDriver driver = null;
	Select select = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

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
		WebElement laptops = driver.findElement(By.cssSelector("div.collapse>ul.nav>li:nth-of-type(2)>a"));
		laptops.click();
		WebElement laptopList = driver.findElement(By.cssSelector("div.collapse>ul.nav>li:nth-of-type(2)>div>a"));
		laptopList.click();
		WebElement selectedLaptop = driver.findElement(By.cssSelector("button[onclick=\"cart.add('47', '1');\"]>span"));
		selectedLaptop.click();
		WebElement addToCartBtn = driver.findElement(By.id("button-cart"));
		addToCartBtn.click();
		WebElement viewShoppingCart = driver.findElement(By.xpath("//a[text()='shopping cart']"));
		viewShoppingCart.click();
		WebElement checkoutBtn = driver.findElement(By.xpath("//a[text()='Checkout']"));
		checkoutBtn.click();
		WebElement emailAddress = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		emailAddress.sendKeys("jimna@gmail.com");
		password.sendKeys("jimna@1234");
		WebElement loginBtn = driver.findElement(By.id("button-login"));
		loginBtn.click();// type is not Submit

		// public void checkout()
		WebElement newAddress = driver.findElement(By.cssSelector("input[value='new']"));
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

		WebElement continueBtn = driver.findElement(By.id("button-payment-address"));
		continueBtn.click();
		WebElement deliveryDetailsContinue = driver.findElement(By.cssSelector("input[id='button-shipping-address']"));
		deliveryDetailsContinue.click();
		WebElement deliveryMethodContinue = driver.findElement(By.id("button-shipping-method"));
		deliveryMethodContinue.click();
		WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
		checkBox.click();
		WebElement paymentMethodContinue = driver.findElement(By.id("button-payment-method"));
		paymentMethodContinue.click();
		WebElement confirmBtn = driver.findElement(By.cssSelector("input[id='button-confirm']"));
		confirmBtn.click();
		WebElement confirmationMessage = driver.findElement(By.cssSelector("div#content>p"));
		// System.out.println(confirmationMessage.getText());

		Assert.assertEquals(confirmationMessage.getText(), "Your order has been successfully processed!");
		WebElement continuefinalBtn = driver.findElement(By.cssSelector("div.pull-right>a"));
		continuefinalBtn.click();
	}

}
