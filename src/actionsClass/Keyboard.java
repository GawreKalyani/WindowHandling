package actionsClass;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Keyboard {
	@Test
	public void test01() throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");

		//Logo Img pe right click-[Select first option(Open image in new tab)--Enter]using robot
		WebElement logo = driver.findElement(By.tagName("img"));
		act.contextClick(logo).build().perform();
		Thread.sleep(5000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);//pressing down arrow key of keyword
		robot.keyPress(KeyEvent.VK_ENTER);//pressing enter button of keyword
		
	

		
	}
}
