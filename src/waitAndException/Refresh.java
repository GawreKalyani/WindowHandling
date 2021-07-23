package waitAndException;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Refresh {

WebDriver driver;
	
	@Test
	public void setUp() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		Thread.sleep(3000);
		//1. driver.navigate().refresh();
		
		//2 Using Robot class
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_F5);
		
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys(Keys.F5);
		
		//3 Actions class ki sendkeys
		Actions a=new Actions(driver);
		WebElement pass=driver.findElement(By.id("password"));
		a.sendKeys(pass, Keys.F5);
		
		//4) Get command:.  it is just feeding get command with a page URL.
		driver.get("https://www.toolsqa.com");
		driver.get(driver.getCurrentUrl());

		//5) To command: This command is again using the same above concept. navigate( ).to( ) is feeding with a page URL and an argument.

		driver.get("https://www.toolsqa.com");
		driver.navigate().to(driver.getCurrentUrl());

		//6) ascii code
		driver.findElement(By.id("email")).sendKeys("\uE035");
		
	}
}
