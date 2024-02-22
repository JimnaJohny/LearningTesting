package com.jimna.jan24.LearningMavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeExample {
	EdgeDriver driver = null;

	@BeforeMethod
	public void intialisation() {
		// Setting the path to the respective driver
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jimna\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		// Launch the browser instance
		driver = new EdgeDriver();

		driver.get("https://demoqa.com/frames");

		// driver.manage().window().maximize();
	}

	@Test
	public void workWithIframeUsingIndex() {
		driver.switchTo().frame(3);
		WebElement sampleText = driver.findElement(By.id("sampleHeading"));
		String text = sampleText.getText();
		System.out.println(text);

	}

	@Test
	public void workWithIframeUsingNameOrID() {
		driver.switchTo().frame("frame1");
		WebElement sampleText = driver.findElement(By.id("sampleHeading"));
		String text = sampleText.getText();
		System.out.println(text);

	}

	@Test
	public void workWithIframeUsingWebElement() {
		WebElement iframeElement = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframeElement);
		WebElement sampleText = driver.findElement(By.id("sampleHeading"));
		String text = sampleText.getText();
		System.out.println(text);

	}

	@Test
	public void movingBetweenFrameAndMainPg() {
		WebElement iframeElement = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframeElement);
		WebElement sampleText = driver.findElement(By.id("sampleHeading"));
		String text = sampleText.getText();
		System.out.println(text);
		
		//Switch Context back to Main or Parent Page
		driver.switchTo().parentFrame();

		// Get text from main Page
		WebElement sampleTextOfSecondIframe = driver.findElement(By.cssSelector("#framesWrapper div:nth-of-type(1) "));

		String textFromMainPg=sampleTextOfSecondIframe.getText();
		System.out.println(textFromMainPg);
		
		
	}
	
	@Test
	public void switchingBetweenFrames() {
		WebElement iframeElement = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframeElement);
		WebElement sampleText = driver.findElement(By.id("sampleHeading"));
		String text = sampleText.getText();
		System.out.println(text);
		
		//Switch to a diff iframe directly from another iframe 
		driver.switchTo().frame("frame2");

		// Get text from main Page
		WebElement sampleTextOfSecondIframe = driver.findElement(By.cssSelector("#framesWrapper div:nth-of-type(1) "));

		String textFromMainPg=sampleTextOfSecondIframe.getText();
		System.out.println(textFromMainPg);
		
		
	}
}
