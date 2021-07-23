package exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElementReferanceEx {
	@Test
	public void testException(){
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
			
		WebElement firstNm=driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
		firstNm.sendKeys("hello");
		driver.navigate().refresh();
		firstNm.sendKeys("hello"); //webElement does not get located after refresh
	}
	@Test(expectedExceptions=StaleElementReferenceException.class)
	public void exceptionHandled(){
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
			
		WebElement firstNm=driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
		firstNm.sendKeys("hello");
		driver.navigate().refresh();
		firstNm.sendKeys("hello"); //webElement does not get located after refresh
	}
	@Test
	public void excphandleByTryCatch(){
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
			
		WebElement firstNm=driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
		firstNm.sendKeys("hello");
		driver.navigate().refresh();
		
		try{
			firstNm.sendKeys("hello");
		} 
		catch(StaleElementReferenceException e){
			firstNm=driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
			firstNm.sendKeys("hello");
		}
	}
}
