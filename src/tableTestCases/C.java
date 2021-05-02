package tableTestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C {
	@Test ///No of Names belongs to Maharashtra
	public void verifyStateMaharashtra() {
		String state="Maharashtra";
		int i=0;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
	List<WebElement> unames =driver.findElements(By.xpath("//tr/td[2]"));// 4 names
	
	List<WebElement> states =driver.findElements(By.xpath("//tr/td[7]"));// 4 states
	ArrayList<String> actData = new ArrayList<String>();
	ArrayList<String> expData = new ArrayList<String>();
	expData.add("Kiran");
	expData.add("Monica");
	for(WebElement element : states) 
	{
		if(element.getText().equals(state)) 
		{    String name=unames.get(i).getText();
			System.out.println(name);      
			actData.add(name);
		}
			i++;
	}
	Assert.assertEquals(actData, expData);
		
}//testcase1 end

	@Test
	public void verifyEmail() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
		List<WebElement> emails =driver.findElements(By.xpath("//tr/td[3]"));// 4 element
	
	for(WebElement element :emails) 
	{
		 String text =element.getText();
		 boolean flag =text.contains("@gmail.com");
		 Assert.assertTrue(flag);
	}

   }//testcase2 end
}//class end