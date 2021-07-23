package parallelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelTest2 {
	WebDriver driver;
	@Test
	public void checkLogo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		driver = new ChromeDriver();// open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		WebElement image = driver.findElement(By.tagName("img"));
		boolean actual = image.isDisplayed();
		boolean expected = true;
		Assert.assertEquals(actual, expected);
		System.out.println("Thread id:"+Thread.currentThread().getId());
		Thread.sleep(5000);
	}
	@Test
	public void checkUrl() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		driver = new ChromeDriver();// open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		String act = driver.getCurrentUrl();
		String exp = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html";
		Assert.assertEquals(act, exp);
		System.out.println("Thread id:"+Thread.currentThread().getId());
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
