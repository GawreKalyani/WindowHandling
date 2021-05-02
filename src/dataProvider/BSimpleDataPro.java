package dataProvider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BSimpleDataPro {
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
		}
	
	@Test(priority=0) 
	public void register(){
		driver.findElement(By.partialLinkText("Register")).click();

	}
	@Test(dataProvider = "registerData",priority=1)
	public void test01(String username,String mob,String uname, String pass) {
		
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mob);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	@DataProvider
	  public Object[][] registerData() {
	    return new Object[][] {
	      new Object[] { "Kiran","988123111","kiran@gmail.com",   "123456" },
	      new Object[] { "Mangesh","6777777712","mangesh@gmail.com", "qwerty" },
	      new Object[] { "Neelam","8999330021","neelam@gmail.com",  "m123456" },
	      new Object[] { "Arya","5422222911","JBK@gmail.com",  "asdfghj" },
	    };
	  }
	@Test(priority=2)
	public void addUser(){
		driver.findElement(By.partialLinkText("I")).click();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
			
	}
	@Test(dataProvider = "addUserData",priority=3)
	public void test02(String name,String mob,String uname, String pass,String courses,String gender,String selectstate) {
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(name);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mob);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("course")).clear();
		driver.findElement(By.id("course")).sendKeys(courses);
		
		WebElement femaleradio=driver.findElement(By.id("Female"));
		WebElement maleradio=driver.findElement(By.id("Male"));
		if(gender.equals("Male"))
			maleradio.click();
			else
				femaleradio.click();
		
		Select state=new Select(driver.findElement(By.tagName("select")));
		state.selectByVisibleText(selectstate);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	@DataProvider
	  public Object[][] addUserData() {
	    return new Object[][] {
	      new Object[] { "Kiran","988123111","kiran@gmail.com","123456","Java","Male","HP" },
	      new Object[] { "Mangesh","6777777712","mangesh@gmail.com", "qwerty","Java","Male","Maharashtra" },
	      new Object[] { "Neelam","8999330021","neelam@gmail.com",  "m123456","Java","Female","Punjab" },
	      new Object[] { "Arya","5422222911","JBK@gmail.com",  "asdfghj","Java","Female","Delhi" },
	    };
	  }

}
