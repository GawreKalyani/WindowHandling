package autoIt;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase {
	public static WebDriver driver=null;
	
	public WebDriver initialisation(){
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");	
	driver=new ChromeDriver();

	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	

	driver.manage().window().maximize();
	return driver;
	}
}
//http://ingecnotechnologies.com/other/Mantis/login_page.php
