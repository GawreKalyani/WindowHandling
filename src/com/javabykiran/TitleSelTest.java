package com.javabykiran;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleSelTest {
//add jar file  for Selenium to run;import:WebDriver,ChromeDriverAlso paste chromeDriver.exe in project
	
	@Test(priority=1)
	public void verifyTitle()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		//Title for login:Data coming on tab
		String title=driver.getTitle();
		String exptitle="JavaByKiran | Log in";
		driver.close();//Return before assert
		
		Assert.assertEquals(title,exptitle);//comparing 2 string(are equal or not)
		//if Equal then test:pass otherwise fail
	}
	
	@Test(priority=2)
	public void verifyHeading()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	
	//Login Page :Heading   Sign in to start your session(index.html)
	String actualheading=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
	String expheading="Sign in to start your session";
	driver.close();
	Assert.assertEquals(actualheading,expheading);
	}
	
	@Test(priority=4)
	public void verifyCourses(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	//head1 (Java Python Selenium)
	String actcourse=driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();			
	String expcouse="JAVA | SELENIUM | PYTHON";
	driver.close();
	Assert.assertEquals(actcourse,expcouse);
	}
	
	@Test(priority=3)
	public void checkHeadingJavabykiran(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	//head2 (Java By Kiran)
	String actualvar=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();		
	String expectedvar="Java By Kiran";
	driver.close();
	Assert.assertEquals(actualvar,expectedvar);
	}
	
	@Test(priority=5)
	public void noLoginDataEnterErrorEmailMessage()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	//Login without data entering
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("password")).sendKeys("");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	String errorMessage=driver.findElement(By.id("email_error")).getText();
	driver.close();
	Assert.assertEquals(errorMessage,"Please enter email.");
	}
	
	@Test(priority=6)
	public void noLoginDataEnterErrorPasswordMessage()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("password")).sendKeys("");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	String errorMessage1=driver.findElement(By.id("password_error")).getText();
	driver.close();
	Assert.assertEquals(errorMessage1,"Please enter password.");
	}
	
	@Test(priority=7)
	public void invalidEmailEntryErrorEmailMessage()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	
	driver.findElement(By.id("email")).sendKeys("kas@gmail.com");
	driver.findElement(By.id("password")).sendKeys("lll");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	String errorMessage1=driver.findElement(By.id("email_error")).getText();
	driver.close();
	Assert.assertEquals(errorMessage1,"Please enter email as kiran@gmail.com");
	}

	@Test(priority=8)
	public void invalidPassEntryErrorPasswordMessage()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	
	driver.findElement(By.id("email")).sendKeys("kas@gmail.com");
	driver.findElement(By.id("password")).sendKeys("lll");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	String errorMessage1=driver.findElement(By.id("password_error")).getText();
	driver.close();
	Assert.assertEquals(errorMessage1,"Please enter password 123456");
	
	}
	@Test(priority=10)
	public void loginSuccessfullyDone()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	String actualdata=driver.getTitle();
	//System.out.println("aa"+actualdata);
	String expectedata="JavaByKiran | Dashboard";
	driver.close();
	Assert.assertEquals(actualdata, expectedata);
	}
	
	@Test(priority=9)
	public void checklogo()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	WebElement image=driver.findElement(By.xpath("/html/body/div/center/img"));
	boolean actual=image.isDisplayed();
	//System.out.println("Image Msg "+actual);//(actual,expected:Both Boolean)
	driver.close();
	Assert.assertEquals(actual,true);	
		}
	@Test
	public void registerNew()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");	
	driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();
	String actualdata=driver.getTitle();
	//System.out.println("Register"+actualdata);
	String expectedata="JavaByKiran|Registration Page";
	driver.close();
	Assert.assertEquals(actualdata, expectedata);
	}

}
