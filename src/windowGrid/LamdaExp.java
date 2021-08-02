package windowGrid;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LamdaExp {
	WebDriver driver;
	
	
	@Test
	public void amazonLink()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("https://www.amazon.in/");
		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		System.out.println("No of Links:"+allLinks.size());  //329 links
		
		for(WebElement ele:allLinks){
			System.out.println(ele.getText());
		}
		//Lamda Expression
		System.out.println("Using Lambda Expression");
		allLinks.forEach(element->System.out.println(element.getText()));
	}
	
}
