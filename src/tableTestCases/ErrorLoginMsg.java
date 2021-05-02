package tableTestCases;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorLoginMsg {
	@Test
	public void verifyLoginErrorMessages() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button")).click();
		ArrayList<String>al=new ArrayList<String>();
		al.add("Please enter email.");
		al.add("Please enter password.");
		
		int i=0;
		List<WebElement>errmsgs=driver.findElements(By.xpath("//div[contains(@id,'error')]"));
		for(WebElement errormsg:errmsgs)
		{
			String actualText=errormsg.getText();
			
			Assert.assertEquals(actualText, al.get(i));
			i++;
		}
	}
		@Test
		public void verifyRegisterErrorMessages() {
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.partialLinkText("Register")).click();
			driver.findElement(By.id("name")).sendKeys("");
			driver.findElement(By.id("mobile")).sendKeys("");
			driver.findElement(By.id("email")).sendKeys("");
			driver.findElement(By.id("password")).sendKeys("");
			driver.findElement(By.xpath("//button")).click();
			ArrayList<String>al=new ArrayList<String>();
			al.add("Please enter Name.");
			al.add("Please enter Mobile.");
			al.add("Please enter Email.");
			al.add("Please enter Password.");
			
			int i=0;
			List<WebElement>errmsgs=driver.findElements(By.xpath("//div[contains(@id,'error')]"));
			for(WebElement errormsg:errmsgs)
			{
				String actualText=errormsg.getText();
				Assert.assertEquals(actualText, al.get(i));
				i++;
			}

		
		
		
	}
}
