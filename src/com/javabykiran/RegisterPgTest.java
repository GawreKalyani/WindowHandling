package com.javabykiran;
//Register a new member(Pg of Login)
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPgTest {

	@Test
	public void registerAnewMemberNameError()
	{
			System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
driver.findElement(By.id("name")).sendKeys("");
driver.findElement(By.id("mobile")).sendKeys("");
driver.findElement(By.id("email")).sendKeys("");
driver.findElement(By.id("password")).sendKeys("");
driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();	
String error=driver.findElement(By.id("name_error")).getText();
String exp1="Please enter Name.";
driver.close();
Assert.assertEquals(error,exp1);

	}
	@Test
	public void registerAnewMemberMobileError()
	{
			System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
driver.findElement(By.id("name")).sendKeys("");
driver.findElement(By.id("mobile")).sendKeys("");
driver.findElement(By.id("email")).sendKeys("");
driver.findElement(By.id("password")).sendKeys("");
driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();	
String error=driver.findElement(By.id("mobile_error")).getText();
String exp1="Please enter Mobile.";
driver.close();
Assert.assertEquals(error,exp1);

		}
	@Test
	public void registerAnewMemberEmailError()
	{
			System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
driver.findElement(By.id("name")).sendKeys("");
driver.findElement(By.id("mobile")).sendKeys("");
driver.findElement(By.id("email")).sendKeys("");
driver.findElement(By.id("password")).sendKeys("");
driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();	
String error=driver.findElement(By.id("email_error")).getText();
String exp1="Please enter Email.";
driver.close();
Assert.assertEquals(error,exp1);

		}
	
	@Test
	public void registerAnewMemberPassError()
	{
			System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
driver.findElement(By.id("name")).sendKeys("");
driver.findElement(By.id("mobile")).sendKeys("");
driver.findElement(By.id("email")).sendKeys("");
driver.findElement(By.id("password")).sendKeys("");
driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();	
String error=driver.findElement(By.id("password_error")).getText();
String exp1="Please enter Password.";
driver.close();
Assert.assertEquals(error,exp1);
}
	@Test
	public void varifyRegisterNewMemberHeading(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	String actual=driver.findElement(By.xpath("/html/body/div/div[2]/a")).getText();
	String expected= "Register a new membership";
	driver.close();	
	Assert.assertEquals(actual,expected);
	}
	@Test
	public void varifyRegisterHeading1(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	String actual=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
	String expected= "Java By Kiran";
	driver.close();	
	Assert.assertEquals(actual,expected);
	}
	@Test
	public void varifyRegisterHeading2(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	String actual=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
	String expected= "Register a new membership";
	driver.close();	
	Assert.assertEquals(actual,expected);
	}
	@Test
	public void checkText(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	String actual=driver.findElement(By.xpath("/html/body/div/div[2]/a")).getText();
	String expected= "I already have a membership";
	driver.close();	
	Assert.assertEquals(actual,expected);	
	}
	@Test
	public void checkButtonText(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	String actual=driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).getText();
	String expected= "Sign In";
	driver.close();	
	Assert.assertEquals(actual,expected);	
	}
	@Test
	public void alreadyRegisteredMember(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	String actual=driver.getTitle();
	String expected= "JavaByKiran | Log in";
	driver.close();	
	Assert.assertEquals(actual,expected);		
	}
	
}
