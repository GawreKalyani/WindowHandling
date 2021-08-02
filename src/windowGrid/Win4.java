package windowGrid;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Win4 {
	WebDriver driver;
	
	@BeforeSuite
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		}
	@Test
	public void testWindows(){
		String parentId=driver.getWindowHandle();
		System.out.println("Parent Window Id= "+parentId);
		
		List<WebElement>moreInfo=driver.findElements(By.partialLinkText("More"));
		for(WebElement link:moreInfo)
		{
		        link.click();
		}
		Set<String>allwindows=driver.getWindowHandles();
		for(String str:allwindows)
		{
			if(!str.equals(parentId))
			{
				System.out.println("child Window id:"+str);
				
				driver.switchTo().window(str);
				
			}
		}
	}
}
