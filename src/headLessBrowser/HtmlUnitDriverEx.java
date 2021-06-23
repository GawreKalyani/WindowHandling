package headLessBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HtmlUnitDriverEx {
	
	@Test(enabled=true)
	public void test(){
	
	WebDriver driver=new HtmlUnitDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	String actual=driver.getTitle();
	System.out.println("Actual:"+actual);
	driver.close();
	Assert.assertEquals(actual, "JavaByKiran | Dashboard");
	}
	
	@Test
	public void verifyText(){
		System.getProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		WebElement headerText=driver.findElement(By.tagName("b"));
		String actual=headerText.getText();
		System.out.println("Actual:"+actual);
		String expected="Java By Kiran";
		System.out.println("Expected:"+expected);
		driver.close();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void login(){
		System.getProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}
	
	
}
