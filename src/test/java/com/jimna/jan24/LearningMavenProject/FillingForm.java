package com.jimna.jan24.LearningMavenProject;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class FillingForm {

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
		public void fillTheForm() {
			WebElement firstName = driver.findElement(By.cssSelector("input[type='text'][name='firstname']"));
			firstName.sendKeys(RandomStringUtils.random(10,new char[]{'a','b','c','d'}));
			WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
			lastName.sendKeys("Johny");
			WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
			email.sendKeys("jimna@gmail.com");
			WebElement telephone = driver.findElement(By.cssSelector("input[name='telephone']"));
			telephone.sendKeys("123456789");
			WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
			password.sendKeys("jimna@1234");
			WebElement confirmPassword = driver.findElement(By.cssSelector("input[name='confirm']"));
			confirmPassword.sendKeys("jimna@1234");
			WebElement subscribeRadioBtn = driver.findElement(By.cssSelector("label.radio-inline input[type='radio'][value='1']"));
			subscribeRadioBtn.click();
			WebElement privacyPolicyCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
			privacyPolicyCheckBox.click();
			WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
			continueBtn.submit();
		}

		@AfterMethod
		public void closing() {
			//driver.close();
		}
}
