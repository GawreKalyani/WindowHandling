package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsEx {
	@Test
	public void test01() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		WebElement logo = driver.findElement(By.tagName("img"));
		act.contextClick(logo).build().perform();
		
		act.click(driver.findElement(By.tagName("img"))).perform();
		
		WebElement uname=driver.findElement(By.id("email"));
		
		act.click(uname).sendKeys("kiran@gmail.com").build().perform();
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}

}
