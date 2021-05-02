package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
	}
	
	
	@Test(dataProvider = "loginData")
	public void test01(String uname, String pass) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		if(driver.getTitle().equals("JavaByKiran | Dashboard"))
			driver.findElement(By.xpath("//a[text()='LOGOUT']")).click();
	//log out button click
	}
	@DataProvider
	  public Object[][] loginData() {
	    return new Object[][] {
	      new Object[] { "kiran@gmail.com",   "123456" },
	      new Object[] { "mangesh@gmail.com", "qwerty" },
	      new Object[] { "neelam@gmail.com",  "m123456" },
	      new Object[] { "JBK@gmail.com",  "asdfghj" },
	    };
	  }

//If we dont want browser to open multiple times,all common terms to be written in
//one method say setUp() ,before mthd give annotation @BeforeTest
	
//For  { "kiran@gmail.com",   "123456" },login successfully--Dashboard pg-obtained
//we dont get login pg to put data for another entry{ "mangesh@gmail.com", "qwerty" },
//so condition ,if driver.getTitle().equals("JavaByKiran | Dashboard")
//then only logout button press(Xpath of logout button.click())
//For  { "mangesh@gmail.com", "qwerty" },says invalid entry errorr msgs
//if we put for"neelam@gmail.com",  "m123456" it comes on same text box
//say "kiran@gmail.comneelam@gmail.com" this problem occurs
//Text box to be cleared write driver.findElement(By.id("email")).clear();
//	driver.findElement(By.id("password")).clear();
	
}
