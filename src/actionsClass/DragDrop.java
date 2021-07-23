package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop {
	@Test
	public void test(){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().window().maximize();
	
	driver.switchTo().frame(0);
	
	WebElement source=driver.findElement(By.id("draggable"));
	WebElement destination=driver.findElement(By.id("droppable"));
	Actions act = new Actions(driver);
	act.dragAndDrop(source, destination);
	}
	
	@Test
	public void rightClick(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/");
		driver.manage().window().maximize();
		WebElement rightClick=driver.findElement(By.cssSelector(".context-menu-one"));
		Actions act = new Actions(driver);
		act.contextClick(rightClick).build().perform();
	}
}
