package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonEx {
		@Test
		public void radioButton(String text){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			
			driver.findElement(By.xpath("//span[text()='Users']")).click();
			driver.findElement(By.xpath("//button[text()='Add User']")).click();
			
			List<WebElement>genders=driver.findElements(By.xpath("//input[@name='gender']"));
			
			for(WebElement gender:genders){
				if(gender.getAttribute("value").equals(text))
				{
					gender.click();
				}
			}
			
		}
		
		@Test
		public void checkSubcourse(){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			ArrayList<String>act=new ArrayList<>();
			List<WebElement>es=driver.findElements(By.xpath("//h3//following::p"));
			for (WebElement webElement : es) {
				String texy=webElement.getText();
				act.add(texy);
			}
			String arr[]={"Automation Testing","Software Development","Data Science","Web Development"};
			 List<String>list=Arrays.asList(arr);
			 Assert.assertEquals(act, list);
		}
}
