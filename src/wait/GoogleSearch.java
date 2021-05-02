package wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleSearch {
	@Test
	public void test01(){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();//maximize window
	WebElement p=driver.findElement(By.name("q")); //xpath:    //input[@name='q']
	p.sendKeys("Selenium Java");
	WebDriverWait wait = new WebDriverWait(driver, 20);		
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul")));
	p.submit();
	driver.close();
}
}
