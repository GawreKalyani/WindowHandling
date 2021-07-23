package waitAndException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitEx {
	@Test
	public void test01(){
	System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
	WebDriver driver = new ChromeDriver();// browser open
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	
	//Browser level waits
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// timeout Exception
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// it will work on all webElements
	//NoSuchElementException
	
	
	//bank Payment (more time for any webelement)
	WebDriverWait wait = new WebDriverWait(driver, 20);		
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	// ElementNOtVisible Exception
	
	
	Wait<WebDriver> w =new FluentWait<WebDriver>(driver)
			.withTimeout(30, TimeUnit.SECONDS)
			.pollingEvery(3, TimeUnit.SECONDS)// 10 pollings
			.ignoring(NoSuchElementException.class);
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	}
}
