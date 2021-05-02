package wait;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectEx {
	

	@Test
	public void test01() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click(); //Users xpath
		driver.findElement(By.xpath("//button[text()='Add User']")).click();   //Add user
		
		//select tag ke liya Use Select Class
		//public Select(WebElement element) ---Constructor of select class
		
		Select state=new Select(driver.findElement(By.tagName("select")));

		//select class ki methods:
		state.selectByValue("HP");   //---dropdown box me HP mile for ex
		//state.selectByText("HP");//state.selectByIndex(3);
	
		List<WebElement>listoption=state.getOptions();
		
		for(WebElement option:listoption)
		{
			System.out.println(option.getText());
		}
		
	}
}
