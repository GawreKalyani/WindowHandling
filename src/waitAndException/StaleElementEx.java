package waitAndException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElementEx {
	@Test
	public void testException(){
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 driver.manage().window().maximize();
		 
		 WebElement link=driver.findElement(By.linkText("Careers"));
		 link.click();
		 driver.navigate().back();
		try{ 
				link.click();
			}
		catch(StaleElementReferenceException e)
		{
			link=driver.findElement(By.className("nav_a"));
			link.click();
		}
		 
		 }
}
