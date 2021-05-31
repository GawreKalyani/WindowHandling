package tableTestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DifferentLogic {
@Test
public void namesForMaharashtra(){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	
	driver.findElement(By.xpath("//span[text()='Users']")).click();

	List<WebElement> unames =driver.findElements(By.xpath("//tr/td[2]"));// 4 element
	List<WebElement> states =driver.findElements(By.xpath("//tr/td[7]"));// 4 element
	int i=0;
	ArrayList<String>actData=new ArrayList<String>();
	ArrayList<String>expData=new ArrayList<String>();
	expData.add("Kiran");
	expData.add("Monica");
	for(WebElement element:states)
	{
		String text=element.getText();
		
		if(text.equals("Maharashtra"))
		{   String name=unames.get(i).getText();
			System.out.println(name);
			actData.add(name);
		}
		i++;
	}
	Assert.assertEquals(actData, expData);
}
@Test
public void testNamesForMaha(){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	
	driver.findElement(By.xpath("//span[text()='Users']")).click();

	List<WebElement> states =driver.findElements(By.xpath("//tr/td[7]"));// 4 element
	int row=2;
	
	ArrayList<String>expData=new ArrayList<String>();
	expData.add("Kiran");
	expData.add("Monica");
	ArrayList<String>actData=new ArrayList<String>();
	for(WebElement element:states)
	{
		String text=element.getText();
		
		if(text.equals("Maharashtra")){
			String name=driver.findElement(By.xpath("//tr["+row+"]/td[2]")).getText();
			System.out.println(name);
			actData.add(name);
		}
		row++;
	}
	Assert.assertEquals(actData, expData);
}
@Test
public void testAllNamesForMaha(){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	
	driver.findElement(By.xpath("//span[text()='Users']")).click();
	ArrayList<String>expData=new ArrayList<String>();
	expData.add("Kiran");
	expData.add("Monica");
	ArrayList<String>actData=new ArrayList<String>();
	
	List<WebElement> states =driver.findElements(By.xpath("//tr/td[7]"));// 4 element
	for(WebElement element:states){
		String text=element.getText();
		if(text.equals("Maharashtra")){
			int index=states.indexOf(element)+2; //0+2=2 Row2 nameKiran
			String name=driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
			System.out.println(name);
			actData.add(name);
		}
	}
	Assert.assertEquals(actData, expData);
}
@Test 
public void testOp(){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	driver.findElement(By.xpath("//span[text()='Downloads']")).click();
	ArrayList<String> expData = new ArrayList<String>();
	expData.add("Java Development Kit (JDK)");
	expData.add("Google Chrome");
	expData.add("Mozilla Firefox");
	expData.add("Gecko Driver for Latest firefox");
	
	List<WebElement>bit32s=driver.findElements(By.xpath("//tr/td[5]"));
	ArrayList<String> actData = new ArrayList<String>();
	 for(WebElement ele:bit32s){
		 if(ele.getText().equals("32bit")) {
			 int index=bit32s.indexOf(ele)+2; 
			String name=driver.findElement(By.xpath("//tr["+index+"]/td[3]")).getText();
			System.out.println(name);
			actData.add(name);
		 }
}
	 Assert.assertEquals(actData, expData);
}
	
}
