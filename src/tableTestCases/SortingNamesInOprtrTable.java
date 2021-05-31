package tableTestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingNamesInOprtrTable {
	WebDriver driver;
	@Test
	public void Test1()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		
		List<WebElement> person =driver.findElements(By.xpath("//tr/td[2]"));
		
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Darshit");
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		
		for (WebElement element : person)
		{
			String name = element.getText();
			
			actData.add(name);
		}
		
		Collections.sort(actData);
		System.out.println(actData);
		
		for (String i : actData)
		{
			System.out.println(i);
		}
		
		Assert.assertEquals(actData, expData);
		driver.close();
	}
	@Test
	public void Test2()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		ArrayList <String>actData1 = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Kimaya");
		expData.add("Kiran");
		expData.add("Monica");
		expData.add("Sagar");
		
		List<WebElement> person =driver.findElements(By.xpath("//td[2]"));
		for(WebElement ele:person){
			String text=ele.getText();
			actData1.add(text);
			System.out.println(text);
		}
		Collections.sort(actData1);
		System.out.println(actData1);
		Assert.assertEquals(actData1, expData);
	}
}
/*kkSystem.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("file:///E:/AutoIT/Upload.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("input")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\AutoIT\\demo.exe");
*/