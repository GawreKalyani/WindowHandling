package dataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class Practise {
WebDriver driver;	
	 @BeforeClass
	  public void beforeClass() 
	 {
		 System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		  driver=new ChromeDriver();
			driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	  }
	 @DataProvider
	  public Object[][] loginData() {
	    return new Object[][] {
	      new Object[] { "kiran@gmail.com", "123456" },
	      new Object[] { "veena@gmail.com", "55555" },
	      new Object[] { "geet@gmail.com", "5555tt5" },
	    };
	  } 
	
	
  @Test(dataProvider = "loginData",priority=1)
  public void verifyLogin(String uname, String pass) 
  {
	  driver.findElement(By.id("email")).clear();
	  driver.findElement(By.id("email")).sendKeys("uname");
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys("pass");
	  driver.findElement(By.xpath("//button")).click();
	  if(driver.getTitle().equals("JavaByKiran | Dashboard"))
		  driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a")).click();
  }
  
  @Test(priority=2)
  public void checkUrl(){
	  String actual=driver.getCurrentUrl();
	  String expected="file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html";
	   
	  Assert.assertEquals(actual, expected);
  }

  @Test(priority=3)
  public void checklogo(){
	  WebElement image=driver.findElement(By.xpath("/html/body/div/center/img"));
  
	  boolean actual=image.isDisplayed();
	  boolean expected=true;
	   
	  Assert.assertEquals(actual, expected);
  }
 
  @Test(priority=4)
  public void Checktitle(){
	  String actual=driver.getTitle();
	  String expected="JavaByKiran | Log in";
	   
	  Assert.assertEquals(actual, expected);
  }
 @Test(priority=5)
 public void CheckHead(){
	  String actual=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
	  String expected="Sign in to start your session";
	   
	  Assert.assertEquals(actual, expected);
 }
@Test(priority=6)
public void checkRegPg(){
	driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	String actual=driver.getTitle();
	String expected="JavaByKiran | Registration Page";
	 
	Assert.assertEquals(actual, expected);
}
}
