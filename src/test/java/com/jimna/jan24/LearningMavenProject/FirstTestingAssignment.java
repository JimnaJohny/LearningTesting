package com.jimna.jan24.LearningMavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestingAssignment {
	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}

	@Test
	public void registerAccount() {
		WebElement firstName = driver.findElement(By.cssSelector("input[type='text'][name='firstname']"));
		WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
		WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
		WebElement telephone = driver.findElement(By.cssSelector("input[name='telephone']"));
		WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
		WebElement confirmPassword = driver.findElement(By.cssSelector("input[name='confirm']"));
		firstName.sendKeys("Jimna");
		lastName.sendKeys("Johny");
		email.sendKeys("jimna@gmail.com");
		telephone.sendKeys("123456789");
		password.sendKeys("jimna@1234");
		confirmPassword.sendKeys("jimna@1234");
		WebElement subscribeRadioBtn = driver
				.findElement(By.cssSelector("label.radio-inline input[type='radio'][value='1']"));
		subscribeRadioBtn.click();
		WebElement privacyPolicyCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
		privacyPolicyCheckBox.click();
		WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		continueBtn.submit();
	}

	@Test
	public void contactUs() {
		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		contactUs.click();
		WebElement yourName = driver.findElement(By.id("input-nameinput-name"));
		WebElement emailAddress = driver.findElement(By.id("input-email"));		
		WebElement enquiry = driver.findElement(By.id("input-enquiry"));
		yourName.sendKeys("Jimna Johny");
		emailAddress.sendKeys("jimna@gmail.com");
		enquiry.sendKeys("I have a few questions");
		WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		submitBtn.submit();
	}

	@Test
	public void returns() {
		WebElement returns = driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[text()='Returns']"));
		returns.click();
		WebElement firstName = driver.findElement(By.id("input-firstname"));		
		WebElement lastName = driver.findElement(By.id("input-lastname"));		
		WebElement email = driver.findElement(By.id("input-email"));		
		WebElement telephone = driver.findElement(By.id("input-telephone"));		
		WebElement orderId = driver.findElement(By.id("input-order-id"));	
		WebElement orderDate = driver.findElement(By.id("input-date-ordered"));		
		WebElement productName = driver.findElement(By.id("input-product"));		
		WebElement productCode = driver.findElement(By.id("input-model"));		
		WebElement quantity = driver.findElement(By.id("input-quantity"));
		firstName.sendKeys("Jimna");
		lastName.sendKeys("Johny");
		email.sendKeys("jimna@gmail.com");
		telephone.sendKeys("123456789");
		orderId.sendKeys("1234");
		orderDate.sendKeys("2024-01-04");
		productName.sendKeys("Canon EOS 5D");
		productCode.sendKeys("EOS 5D");
		quantity.sendKeys("1");
		WebElement radioBtnReasonForReturn = driver.findElement(By.cssSelector("input[value='2']"));
		radioBtnReasonForReturn.click();
		WebElement radioBtnOpened = driver.findElement(By.cssSelector("input[value='0']"));
		radioBtnOpened.click();
		WebElement submitBtn = driver.findElement(By.cssSelector("input[value='Submit']"));
		submitBtn.submit();
	}

	@Test
	public void giftCertificates() {
		WebElement giftCertificates = driver.findElement(By.xpath("//a[text()='Gift Certificates']"));
		giftCertificates.click();
		WebElement recipientsName = driver.findElement(By.id("input-to-namey"));
		recipientsName.sendKeys("Austro");
		WebElement recipientsEmail = driver.findElement(By.id("input-to-email"));
		recipientsEmail.sendKeys("austro@gmail.com");
		WebElement yourName = driver.findElement(By.id("input-from-name"));
		yourName.sendKeys("Jimna");
		WebElement yourEmail = driver.findElement(By.id("input-from-email"));
		yourEmail.sendKeys("jimna@gmail.com");
		WebElement radioBtnGiftCertificateTheme = driver.findElement(By.cssSelector("input[value='7']"));
		radioBtnGiftCertificateTheme.click();
		WebElement message = driver.findElement(By.id("input-message"));
		message.sendKeys("Happy B'day");
		WebElement amount = driver.findElement(By.cssSelector("input[value='1'][name='amount']"));
		amount.sendKeys("1");
		WebElement checkBoxAgree = driver.findElement(By.cssSelector("input[type='checkbox']"));
		checkBoxAgree.click();
		WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
		continueBtn.submit();
	}

	@Test
	public void login() {
		List<WebElement> rightColumn = driver.findElements(By.cssSelector("#column-right>div>a"));
		if (rightColumn.size() > 0) {
			for (int i = 0; i < rightColumn.size(); i++) {
				if (rightColumn.get(i).getText().equals("Login")) {
					rightColumn.get(i).click();
					WebElement emailAddress = driver.findElement(By.id("input-email"));
					emailAddress.sendKeys("jimna@gmail.com");
					WebElement password = driver.findElement(By.id("input-password"));
					password.sendKeys("jimna@1234");
					WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
					loginBtn.submit();
					break;
				}
			}
		} else {
			throw new NullPointerException("Webelement list is empty");
		}
	}

	@Test
	public void updatePassword() {
		List<WebElement> rightColumn = driver.findElements(By.cssSelector("#column-right>div>a"));
		if (rightColumn.size() > 0) {
			for (int i = 0; i < rightColumn.size(); i++) {
				if (rightColumn.get(i).getText().equals("Forgotten Password")) {
					rightColumn.get(i).click();
					WebElement emailAddress = driver.findElement(By.id("input-email"));
					emailAddress.sendKeys("jimna@gmail.com");
					WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
					continueBtn.submit();
					WebElement emailAlert = driver
							.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
					boolean isEmailAlertSent = emailAlert.isDisplayed();
					System.out.println(isEmailAlertSent);
					break;
				}
			}
		} else {
			throw new NullPointerException("Webelement list is empty");
		}
	}

	@Test
	public void editAccount() {
		List<WebElement> rightColumn = driver.findElements(By.cssSelector("#column-right>div>a"));
		if (rightColumn.size() > 0) {
			for (int i = 0; i < rightColumn.size(); i++) {
				if (rightColumn.get(i).getText().equals("My Account")) {
					rightColumn.get(i).click();
					WebElement emailAddress = driver.findElement(By.id("input-email"));
					emailAddress.sendKeys("jimna@gmail.com");
					WebElement password = driver.findElement(By.id("input-password"));
					password.sendKeys("jimna@1234");
					WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
					loginBtn.submit();
					WebElement editAccount = driver.findElement(By.xpath("//a[text()='Edit Account']"));
					editAccount.click();
					WebElement telephoneNumber = driver.findElement(By.id("input-telephone"));
					telephoneNumber.clear();
					telephoneNumber.sendKeys("2265128912");
					WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
					continueBtn.submit();

				}
			}
		} else {
			throw new NullPointerException("Webelement list is empty");
		}
	}

	@AfterMethod
	public void closing() {
		// driver.close();
	}
}
