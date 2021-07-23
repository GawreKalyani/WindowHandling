package parallelTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelTest1 {
	WebDriver driver;
	@Test
	public void averifyTitle() {
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		String exptitle = "JavaByKiran | Log in";
		Assert.assertEquals(title, exptitle);
		System.out.println("Thread id:"+Thread.currentThread().getId());
	}
	@Test
	public void checkLoginSuccessfullyDone() {
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		driver = new ChromeDriver();// open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String actualdata = driver.getTitle();
		System.out.println("aa"+actualdata);
		String expectedata = "JavaByKiran | Dashboard";
		Assert.assertEquals(actualdata, expectedata);
		System.out.println("Thread id:"+Thread.currentThread().getId());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
