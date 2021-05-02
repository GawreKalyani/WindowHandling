package dataProvider;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Registration {
WebDriver driver;	
	 @BeforeTest
	  public void setUp() 
	 {
		 System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		 driver=new ChromeDriver();//open browser
			driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	  }
	
	 @Test(priority=1)
	public void checkRegistration()
	{
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("name")).sendKeys("Afsana Sheik");
		driver.findElement(By.id("mobile")).sendKeys("8777073331");
		driver.findElement(By.id("email")).sendKeys("afsana@gmail.com");
		driver.findElement(By.id("password")).sendKeys("34567");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();	
		Alert al=driver.switchTo().alert();
		al.accept();
	}
 
	

}
