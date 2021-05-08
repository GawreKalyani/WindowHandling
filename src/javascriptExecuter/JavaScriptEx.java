package javascriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaScriptEx {

	static WebDriver driver;
	
	public static void scrollingToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void main(String[] args) throws Exception{
		WebElement uname, pass;
		//RemoteWebDriver rwd;
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver= new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
		//RemoteWebDriver d;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(js.executeScript("return document.URL;"));
		
		System.out.println(driver.getTitle());
		System.out.println(js.executeScript("return document.title;"));
		
		// chnging title by js
	     js.executeScript("document.title='updated title';");
	     System.out.println(driver.getTitle());
	     
	   //refreshing browser by js
	     js.executeScript("history.go(0);");
	     
	   //clicking element by js
	     js.executeScript("arguments[0].click();", uname=driver.findElement(By.id("email")));
	     
	     js.executeScript("document.getElementById('email').value='kiran@gmail.com';");

	     //clicking element by js

	     js.executeScript("arguments[0].click();", pass=driver.findElement(By.id("password")));

	     // using sendkeys by js

	     js.executeScript("document.getElementById('password').value='123456';");
	     
	  // creating alert by js
	     js.executeScript("alert('hello world');");
	     Alert al = driver.switchTo().alert();
	     System.out.println(al.getText());
	     Thread.sleep(5000);
	     al.accept();
	     
	   //navigating to other page by js
	     js.executeScript("window.location='https://www.amazon.in/'");
	     Thread.sleep(10000);
	     driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	     WebElement footer_Logo=driver.findElement(By.xpath("//a[@href='/ref=footer_logo']"));
	     js.executeScript("arguments[0].scrollIntoView(true);", footer_Logo);
	     System.out.println(driver.getTitle());
	    // driver.navigate().to("");
	  }
}
/*
 file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html
file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html
JavaByKiran | Log in
JavaByKiran | Log in
updated title
hello world    */
