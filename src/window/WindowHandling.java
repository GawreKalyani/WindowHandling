package window;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandling {
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
		}
	@Test
	public void wintest(){
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();     //1window  //Dashbord pg url
		
		String parentId=driver.getWindowHandle();
		System.out.println("Parent Window Id= "+parentId);  //Parent Window Id= CDwindow-401645F3D4AF0B68988F2BE5C8170DAA
		
		//DashboardPg--Selenium Box---More info
		driver.findElement(By.partialLinkText("More")).click();
		
//After clicking More info we get this url		
String expUrl="file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf";
		
	Set<String>allwins=driver.getWindowHandles();	
	for(String str:allwins)
	{
		if(!str.equals(parentId))
		{
			System.out.println("child Window id:"+str);//child Window id:CDwindow-7A14A91173BB51F8E68E535DF63F0CD3
			
			driver.switchTo().window(str);
			Assert.assertEquals(driver.getCurrentUrl(), expUrl);
		}
	}
		
		
		
	}
}
