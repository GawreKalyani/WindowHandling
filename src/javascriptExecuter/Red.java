package javascriptExecuter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Red {
	WebDriver driver;
	@Test
	public void getNoOfFrameAndScrolling() throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.redbus.in/");
		 driver.manage().window().maximize();
		 List<WebElement>frammm=driver.findElements(By.xpath("//iframe"));
		 int countframe=frammm.size();
		 System.out.println(countframe);
		 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,2000)","");//scroll down vertical scroll down
	Thread.sleep(2000);
	
	js.executeScript("window.scrollBy(0,-2000)", "");//scroll down vertical scroll up
	Thread.sleep(3000);

	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");//scroll full down
	Thread.sleep(3000);
	js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");//scroll full up 

	}
}
