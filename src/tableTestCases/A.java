package tableTestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//Verifying mobile length is 10 or not and get there names(by 2 method)
public class A {
	@Test
	public void verifyMobile() {
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
	List<WebElement> mobiles =driver.findElements(By.xpath("//tr/td[4]"));// 4 element
	WebElement e1=null;
		SoftAssert sa = new SoftAssert();
		
		for(WebElement element : mobiles)
		{
			String text = element.getText();//
			int noOfDig = text.length();
			
			if(noOfDig==10) 
			{
				int index=mobiles.indexOf(element)+2;
				System.out.println(index);
				e1 = driver.findElement(By.xpath("//tr["+index+"]/td[2]"));
				System.out.println("moblie number is correct for: "+e1.getText());
			}
			
			else {
					int index=mobiles.indexOf(element)+2;
					System.out.println(index);
					e1 = driver.findElement(By.xpath("//tr["+index+"]/td[2]"));
					System.out.println("moblie number is not correct for: "+e1.getText());
				}
				sa.assertEquals(noOfDig, 10);
				
			}//for loop end	
					
		sa.assertAll();
		
				}//test end
	
	@Test
	public void testMobNo(){ //method 2

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
int i=2;	SoftAssert sa = new SoftAssert();
	List<WebElement> mobiles =driver.findElements(By.xpath("//tr/td[4]"));// 4 element
	for(WebElement e:mobiles)
	{
		String text=e.getText();
		int noD=text.length();
		if(noD==10)
		{	System.out.println("MobileNo is correct for:");
			String name=driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
			System.out.println(name);
		}
		else
		{	System.out.println("MobileNo is not correct for:");
			String name=driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
			System.out.println(name);	
		}
		i++;
		sa.assertEquals(noD, 10);
	}
sa.assertAll();
}
	@Test
	public void testNavigator(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		ArrayList <String>expData = new ArrayList <>();
		expData.add("Dashboard");
		expData.add("Users");
		expData.add("Operators");
		expData.add("Useful Links");
		expData.add("Downloads");
		expData.add("Logout");
		ArrayList <String>actData = new ArrayList <>();
		List<WebElement>navigator=driver.findElements(By.xpath("//li//span"));	
		for(WebElement ele:navigator){
			String text=ele.getText();
			System.out.println(text);
			actData.add(text);
		}
		Assert.assertEquals(actData, expData);
	}
	@Test
	public void verifyJBK_Link () throws InterruptedException 
	{System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='JavaByKiran']")).click();
		Thread.sleep(10000);
		
		Set <String> allWindows = driver.getWindowHandles();
		
		String actWindowTitle = null ;
		String expWindowTitle = "Java Classes in Pune | Selenium Training | Python Courses in pune";
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actWindowTitle = driver.getTitle();
				driver.close();
			}
		}
		Assert.assertEquals(actWindowTitle, expWindowTitle);
		driver.switchTo().window(parent);
	}
	@Test
	public void verifyTeacherNameForJava(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		ArrayList<String>actData=new ArrayList<String>();
		List<WebElement> course =driver.findElements(By.xpath("//tr/td[5]"));// 4 element
		for(WebElement element : course) 
		{
			if(element.getText().contains("Java/J2EE")) 	
			{  
				int index= course.indexOf(element)+2;
				String name=driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
				System.out.println(name);      
				actData.add(name);
			}
		}
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		Assert.assertEquals(actData, expData);
	}
	@Test
	public void testHh(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();	
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("You can not delete Default User");
		expData.add("You can not delete Default User");
		ArrayList<String>actData=new ArrayList<String>();
		List<WebElement> action =driver.findElements(By.xpath("//span[contains(@onclick,'alert')]"));// 2 element
		for(WebElement element : action) 
		{
			element.click();
			Alert al=driver.switchTo().alert();
			String t=al.getText();
			System.out.println(t);
			actData.add(t);
			al.accept();
		}
		Assert.assertEquals(actData, expData);
	}
	@Test
	public void testHhgg(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();	
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Are you sure you want to delete this user");
		expData.add("Are you sure you want to delete this user");
		ArrayList<String>actData=new ArrayList<String>();
		List<WebElement> action =driver.findElements(By.xpath("//span[contains(@onclick,'user')]"));// 2 element
		for(WebElement element : action) 
		{
			element.click();
			Alert al=driver.switchTo().alert();
			String t=al.getText();
			System.out.println(t);
			actData.add(t);
			al.dismiss();
		}
		Assert.assertEquals(actData, expData);
	}
	@Test
	public void test2AlertMsgForDeleteBtnRow2and4(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();	
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("User deleted successfully.");
		expData.add("User deleted successfully.");
		ArrayList<String>actData=new ArrayList<String>();
		List<WebElement> action =driver.findElements(By.xpath("//span[contains(@onclick,'user')]"));// 2 element
		for(WebElement element : action) 
		{
			element.click();
			Alert al=driver.switchTo().alert();
			//System.out.println(al.getText());
			al.accept();
			//if(ExpectedConditions.alertIsPresent()!=null){
			Alert al1=driver.switchTo().alert();
			String text=al1.getText();
			actData.add(text);
			al1.accept();
			System.out.println(text);
			
			//}
		}
		Assert.assertEquals(actData, expData);
	}
}
//https://github.com/mangesh1404/KeywordFramework_8May.git
	
