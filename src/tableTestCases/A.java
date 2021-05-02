package tableTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
}
	
