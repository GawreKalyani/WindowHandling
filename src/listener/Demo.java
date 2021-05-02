package listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerExample.class)

public class Demo {
	
WebDriver driver;

	@Test(priority=-1)
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();// one win opened
		Assert.assertEquals(0, 1);
	}

	@Test(dependsOnMethods="loginTest",priority=0)
	public void verifyTitle()  
	{
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test(priority=1)
	public void test03() {
		Assert.assertEquals(0, 1);
	}
	

	@Test(priority=2)
	public void test04() {
		Assert.assertEquals(1, 1);
	}

}
