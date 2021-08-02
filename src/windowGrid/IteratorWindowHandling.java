package windowGrid;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IteratorWindowHandling {
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();     //1window  //Dashbord pg url
		}
	@Test
	public void wintest(){
		String parentId=driver.getWindowHandle();
		System.out.println("DashboardPg "+parentId);
		List<WebElement>allMoreInfo=driver.findElements(By.partialLinkText("More"));
			for(WebElement ele:allMoreInfo )
			{
				ele.click();
			}
			Set<String>allWindows=driver.getWindowHandles();
			Iterator<String>it=allWindows.iterator();
			while(it.hasNext()){
				String child=it.next();
				System.out.println("All Total Windows: "+child);
				if(parentId.equals(child)){
					driver.switchTo().window(child);
				}
			}
			
		}
	
	
	}
		

