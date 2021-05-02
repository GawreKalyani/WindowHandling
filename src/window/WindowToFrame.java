package window;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WindowToFrame {
	WebDriver driver;
	@Test
	public void test1(){
		ChromeOptions cop=new ChromeOptions();
		cop.addArguments("---disable-notification");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.redbus.in/?gclid=Cj0KCQjwsLWDBhCmARIsAPSL3_1NmFtbFO_UAY9F1ViEMWxbfONJzBRtqI8_GEVDglW-sSr0A24lYpAaAuyIEALw_wcB");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebElement profile=driver.findElement(By.xpath("//i[@id='i-icon-profile']"));
		profile.click();
		
		WebElement signIn=driver.findElement(By.xpath("//li[@id='signInLink']"));
		signIn.click();
		
//Window containing frame	 (One window)
		System.out.println("main/parent window title:  "+driver.getTitle());
		String parentWindow=driver.getWindowHandle();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//frame
		WebElement iframe=driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
		driver.switchTo().frame(iframe);
		
		//facebook option found on frame
WebElement facebook=driver.findElement(By.xpath("//a[contains(text(),'Terms')]//preceding::div[text()='Facebook']"));
		facebook.click();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//facebook window
			//Browser contains two windows(frameWindow Url,facebook)
				Set<String>allwindows=driver.getWindowHandles();	
				for(String childWindow:allwindows)
				{
					if(!childWindow.equals(parentWindow))
					{
						driver.switchTo().window(childWindow);
					}
				}
		
		WebElement email=driver.findElement(By.id("//input[@id='email']"));
		email.sendKeys("urr@gmail.com");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("1234h");
		
		WebElement logIn=driver.findElement(By.xpath("//input[@type='submit']"));
		logIn.click();
	}
}