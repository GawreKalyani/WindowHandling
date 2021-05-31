package window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToolTip {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
		}
	@Test(priority=1)	//getting value passed in textbox
	public void testLogin(){
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		String x=driver.findElement(By.id("email")).getAttribute("value");
		System.out.println(x);
		driver.findElement(By.id("password")).sendKeys("123456");
		System.out.println(driver.findElement(By.id("password")).getAttribute("value"));
		driver.findElement(By.xpath("//button")).click();
		}
	
	@Test(priority=2)
	public void testToolTip()
	{
		driver.findElement(By.xpath("//span[text()='Users']")).click(); //userPg
		
		WebElement delBtn=driver.findElement(By.xpath("//span[text()='Delete']"));
		
		String toolTipMsg=delBtn.getAttribute("title"); //getAttribute(Attribute): We get attribute value
		
		Assert.assertEquals(toolTipMsg, "Click to Delete");
	}
	@Test(priority=3)
	public void testPlaceHolderEmail(){
		driver.findElement(By.partialLinkText("LOGOUT")).click();
		WebElement email=driver.findElement(By.id("email"));
		String actual=email.getAttribute("placeholder");
		String expected="Email";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=4)
	public void testC(){
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		WebElement copy=driver.findElement(By.xpath("//strong[contains(text(),'right')]"));
		System.out.println(copy.getText());
		Assert.assertEquals(copy.getText(), "Copyright © 2005-2019 JavaByKiran.");
	}
	@Test(priority=5)
	public void testDesign(){
		WebElement des=driver.findElement(By.xpath("//b[contains(text(),'Des')]"));
		Assert.assertEquals(des.getText(), "Design for Selenium Automation Test");
	}
}
//Delete Btn Inspect
//<span class="label label-danger" onclick="return alert('You can not delete Default User')" 
//data-toggle="tooltip" data-placement="top" title="Click to Delete">Delete</span>