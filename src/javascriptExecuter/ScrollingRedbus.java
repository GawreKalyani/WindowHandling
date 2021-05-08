package javascriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingRedbus {
	static WebDriver driver;
public static void main(String[] args) throws Exception {

	
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 driver= new ChromeDriver();
	 driver.get("https://www.redbus.in/");
	//js.executeScript("window.location='https://www.redbus.in/'");
     Thread.sleep(10000);
     driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 	WebElement section=driver.findElement(By.xpath("//section[@class='clearfix main-body']"));

	JavascriptExecutor js = (JavascriptExecutor)driver;
     js.executeScript("arguments[0].scrollIntoView(true);", section);
}
}
