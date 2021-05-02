package com.javabykiran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {
	
	@Test(priority=1)
	public void checkLogo()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	WebElement image=driver.findElement(By.tagName("img"));
	boolean actual=image.isDisplayed();
	boolean expected=true;
	driver.close();
	Assert.assertEquals(actual,expected);	
	}
	
	@Test(priority=2)
	public void checkUrl()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	String act=driver.getCurrentUrl();	
	String exp="file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html";
	driver.close();
	Assert.assertEquals(act,exp);
	}

	@Test(priority=3)
	public void verifyTitle()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		
		String title=driver.getTitle();
		String exptitle="JavaByKiran | Log in";
		driver.close();
		Assert.assertEquals(title,exptitle);
	}
	
	@Test(priority=4)
	public void checkHeadingJavabykiran(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	//head2 (Java By Kiran)
	String actualvar=driver.findElement(By.xpath("//b[contains(text(),'Kiran')]")).getText();		
	String expectedvar="Java By Kiran";
	driver.close();
	Assert.assertEquals(actualvar,expectedvar);
	}
	
	@Test(priority=5)
	public void verifyCoursesHeading(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	//head1 (Java Python Selenium)
	String actcourse=driver.findElement(By.xpath("//h4[contains(text(),'JAVA')]")).getText();			
	String expcouse="JAVA | SELENIUM | PYTHON";
	driver.close();
	Assert.assertEquals(actcourse,expcouse);
	}
	
	@Test(priority=6)
	public void verifySignInHeading()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	
	//Login Page :Heading   Sign in to start your session(index.html)
	String actualheading=driver.findElement(By.xpath("//p[contains(text(),'Sign')]")).getText();
	String expheading="Sign in to start your session";
	driver.close();
	Assert.assertEquals(actualheading,expheading);
	}
	
	@Test(priority=7)
	public void checkLoginSuccessfullyDone()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	String actualdata=driver.getTitle();
	//System.out.println("aa"+actualdata);
	String expectedata="JavaByKiran | Dashboard";
	driver.close();
	Assert.assertEquals(actualdata, expectedata);
	}
	
	@Test(priority=8)
	public void verifyBlankEmailErrorMsg()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	//Login without data entering
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("password")).sendKeys("");
	driver.findElement(By.xpath("//button")).click();
	String errorMessage=driver.findElement(By.id("email_error")).getText();
	driver.close();
	Assert.assertEquals(errorMessage,"Please enter email.");
	}
	
	@Test(priority=9)
	public void verifyBlankPasswordErrorMsg()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("password")).sendKeys("");
	driver.findElement(By.xpath("//button")).click();
	String errorMessage1=driver.findElement(By.id("password_error")).getText();
	driver.close();
	Assert.assertEquals(errorMessage1,"Please enter password.");
	}
	
	@Test(priority=10)
	public void verifyInvalidLoginEntryEmailErrorMessage()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	
	driver.findElement(By.id("email")).sendKeys("kas@gmail.com");
	driver.findElement(By.id("password")).sendKeys("lll");
	driver.findElement(By.xpath("//button")).click();
	String errorMessage1=driver.findElement(By.id("email_error")).getText();
	driver.close();
	Assert.assertEquals(errorMessage1,"Please enter email as kiran@gmail.com");
	}

	@Test(priority=11)
	public void verifyInvalidLoginEntryPasswordErrorMessage()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	
	driver.findElement(By.id("email")).sendKeys("kas@gmail.com");
	driver.findElement(By.id("password")).sendKeys("lll");
	driver.findElement(By.xpath("//button")).click();
	String errorMessage1=driver.findElement(By.id("password_error")).getText();
	driver.close();
	Assert.assertEquals(errorMessage1,"Please enter password 123456");
	}
	
	@Test(priority=12)
	public void checkRegistration()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.partialLinkText("Register")).click();
	String actualdata=driver.getTitle();
	System.out.println("Register"+actualdata);
	String expectedata="JavaByKiran | Registration Page";
	driver.close();
	Assert.assertEquals(actualdata, expectedata);
	}
	
	@Test(priority=13)
	public void checkRegisterPgHeading()
	{
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	String actual=driver.findElement(By.xpath("//b[contains(text(),'Java')]")).getText();
	String expected= "Java By Kiran";
	driver.close();	
	Assert.assertEquals(actual,expected);
	}
	
	@Test(priority=14)
	public void varifyRegisterHeading2(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	String actual=driver.findElement(By.xpath("//p[contains(text(),'Register')]")).getText();
	String expected= "Register a new membership";
	driver.close();	
	Assert.assertEquals(actual,expected);
	}
	
	@Test(priority=15)
	public void checkRegisterPgNameError()
	{
			System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	driver.findElement(By.id("name")).sendKeys("");
	driver.findElement(By.id("mobile")).sendKeys("");
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("password")).sendKeys("");
	driver.findElement(By.xpath("//button[contains(text(),'In')]")).click();	
	String error=driver.findElement(By.id("name_error")).getText();
	String exp1="Please enter Name.";
	driver.close();
	Assert.assertEquals(error,exp1);
	}
	
	@Test(priority=16)
	public void checkRegisterPgMobileError()
	{
			System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	driver.findElement(By.id("name")).sendKeys("");
	driver.findElement(By.id("mobile")).sendKeys("");
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("password")).sendKeys("");
	driver.findElement(By.xpath("//button[contains(text(),'In')]")).click();	
	String error=driver.findElement(By.id("mobile_error")).getText();
	String exp1="Please enter Mobile.";
	driver.close();
	Assert.assertEquals(error,exp1);
	}
	
	@Test(priority=17)
	public void checkRegisterPgEmailError()
	{
			System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	driver.findElement(By.id("name")).sendKeys("");
	driver.findElement(By.id("mobile")).sendKeys("");
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("password")).sendKeys("");
	driver.findElement(By.xpath("//button[contains(text(),'In')]")).click();	
	String error=driver.findElement(By.id("email_error")).getText();
	String exp1="Please enter Email.";
	driver.close();
	Assert.assertEquals(error,exp1);
	}
	
	@Test(priority=18)
	public void checkRegisterPgPasswordError()
	{
			System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
			WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	driver.findElement(By.id("name")).sendKeys("");
	driver.findElement(By.id("mobile")).sendKeys("");
	driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("password")).sendKeys("");
	driver.findElement(By.xpath("//button[contains(text(),'In')]")).click();	
	String error=driver.findElement(By.id("password_error")).getText();
	String exp1="Please enter Password.";
	driver.close();
	Assert.assertEquals(error,exp1);
	}
	
	@Test(priority=19)
	public void verifyAlreadyRegisteredMember(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	driver.findElement(By.xpath("//a[contains(text(),'I')]")).click();
	String actual=driver.getTitle();
	String expected= "JavaByKiran | Log in";
	driver.close();	
	Assert.assertEquals(actual,expected);		
	}
	
	@Test(priority=20)
	public void checkRegPgUrl(){
	System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
	WebDriver driver=new ChromeDriver();//open browser
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	String act=driver.getCurrentUrl();	
	String exp=("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
	driver.close();
	Assert.assertEquals(act,exp);	
	}
	
	
	
	
	
	
	
	
}


