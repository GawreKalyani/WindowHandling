package tableTestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.Assert;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class D {
int row=2;	
	
	@Test  //no of names present on monday
	public void verifyTeacherPresentOnMonday() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		List<WebElement> unames =driver.findElements(By.xpath("//tr/td[2]"));// 5 names
		
		List<WebElement> timing =driver.findElements(By.xpath("//tr/td[6]/b"));// 5 timings
	
		ArrayList<String> actData = new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		
		int i=0;
		for(WebElement element : timing) 
		{
			String text=element.getText().substring(0,6);	
			if(text.equals("Monday")){
				String name=unames.get(i).getText();
				System.out.println(name);
				actData.add(name);
			}
			i++;
		}
		
		Assert.assertEquals(actData, expData);
}
	
	
	@Test  //no of names present on sunday
	public void test()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		List<WebElement> unames =driver.findElements(By.xpath("//tr/td[2]"));// 5 names
		
		List<WebElement> timing =driver.findElements(By.xpath("//tr/td[6]/b"));// 5 timings
	
		ArrayList<String> actData = new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Varsha");
		expData.add("Darshit");
		
		
		int i=0;
		for(WebElement element : timing) 
		{
			if(element.getText().contains("Sunday")){
				String name=unames.get(i).getText();
				System.out.println(name);
				actData.add(name);
			}
			i++;
		}
		
		Assert.assertEquals(actData, expData);
}
@Test
public void verifyOperatorsNamesNotOnSunday() {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	
	driver.findElement(By.xpath("//span[text()='Operators']")).click();
	
	List<WebElement> timings = driver.findElements(By.xpath("//td[6]"));//timing
	ArrayList <String>actData = new ArrayList <>();
	
	ArrayList <String>expData = new ArrayList <>();
	expData.add("Neelam");
	expData.add("Seema");
	
	
	int i=2;//row2
	for(WebElement e1 :timings) 
	{
		String xpath ="//tr["+ i + "]/td[2]" ;//names xpath //tr/td[2]
		System.out.println(xpath);
		String text = e1.getText();
		if(!text.contains("Sunday")) 
		{
			String name = driver.findElement(By.xpath(xpath)).getText();
		
		System.out.println("employee not available on Sunday is: "+name);
		actData.add(name);
		}
		i++;
	}//for loop end
	/*          //tr[2]/td[2] kiran
				//tr[3]/td[2]
				employee not available on Sunday is: Neelam
				//tr[4]/td[2]
				employee not available on Sunday is: Seema
				//tr[5]/td[2]
				//tr[6]/td[2]
				PASSED: verifyOperators  */
	Assert.assertEquals(actData, expData);
	}//testcaseEnd
@Test
public void verifyVendorAndVersionOf_32bit() throws BiffException, IOException {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	
	driver.findElement(By.xpath("//span[text()='Downloads']")).click();
	HashMap<String,	List<String>> actualhm = new HashMap<String, List<String>>();

	List<WebElement> bits = driver.findElements(By.xpath("//td[5]"));
	List<WebElement> versions = driver.findElements(By.xpath("//td[4]"));
	List<WebElement> vendors = driver.findElements(By.xpath("//td[3]"));
	String version=null;
	String vendor = null;
	for (int i = 0; i < vendors.size(); i++) {
		String key = bits.get(i).getText();

		 version = versions.get(i).getText();
		 vendor = vendors.get(i).getText();

		List<String> al = new ArrayList<String>();
		al.add(vendor);
		al.add(version);

		actualhm.put(key, al);
		System.out.println(actualhm);
	}
	}
@Test(dataProvider="loginData")
public void test1(String sr,String name,String email,String mobile,String course,String gender,String state,String action){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	driver.findElement(By.xpath("//span[text()='Users']")).click();
	ArrayList<String> actData = new ArrayList<String>();
	ArrayList<String> expData = new ArrayList<String>();
	expData.add(sr);
	expData.add(name);
	expData.add(email);
	expData.add(mobile);
	expData.add(course);
	expData.add(gender);
	expData.add(state);
	expData.add(action);
	if(row==2){
	List<WebElement>rowData1= driver.findElements(By.xpath("//tr[2]/td"));
	for(WebElement ele:rowData1)
	{
		String text=ele.getText();
		System.out.println(text);
		actData.add(text);
	}
	}
	else if(row==3){
	List<WebElement>rowData2= driver.findElements(By.xpath("//tr[3]/td"));
	for(WebElement ele:rowData2)
	{
		String text=ele.getText();
		System.out.println(text);
		actData.add(text);
	}
	}
	else if(row==4){
	List<WebElement>rowData3= driver.findElements(By.xpath("//tr[4]/td"));
	for(WebElement ele:rowData3)
	{
		String text=ele.getText();
		System.out.println(text);
		actData.add(text);
	}
	}
	else{
	List<WebElement>rowData4= driver.findElements(By.xpath("//tr[5]/td"));
	for(WebElement ele:rowData4)
	{
		String text=ele.getText();
		System.out.println(text);
		actData.add(text);
	}}
	row++;
	Assert.assertEquals(actData, expData);
	}
@DataProvider
public Object[][] loginData() {
  return new Object[][] {
    new Object[] {"1","Kiran","kiran@gmail.com","9898989898","Java/J2EE","Male","Maharashtra","Delete" },
    new Object[] {"2","Sagar","sagar@gmail.com","999999999","Selenium","Male","Punjab","Delete" },
    new Object[] {"3","Monica","monica@gmail.com", "1111111111","Python","Female","Maharashtra","Delete" },
    new Object[] {"4","Kimaya","kimaya@gmail.com", "999999999","PHP","Female","Punjab","Delete" },
  };
} 

@Test(dataProvider="loginData1")
public void test02User(String sr,String name,String email,String mobile,String course,String gender,String state,String action){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();
	driver.findElement(By.xpath("//span[text()='Users']")).click();	
	ArrayList<String>actData=new ArrayList<String>();
	ArrayList<String> expData = new ArrayList<String>();
	expData.add(sr);
	expData.add(name);
	expData.add(email);
	expData.add(mobile);
	expData.add(course);
	expData.add(gender);
	expData.add(state);
	expData.add(action);
		List<WebElement>rowData1= driver.findElements(By.xpath("//tr"));
		for(WebElement ele:rowData1)
		{
			String text=ele.getText();
			System.out.println(text);
			actData.add(text);
		}
		
}
@DataProvider
public Object[][] loginData1() {
  return new Object[][] {
	  new Object[] {"#","Username","Email","Mobile","Course","Gender","State","Action"},
    new Object[] {"1","Kiran","kiran@gmail.com","9898989898","Java/J2EE","Male","Maharashtra","Delete" },
    new Object[] {"2","Sagar","sagar@gmail.com","999999999","Selenium","Male","Punjab","Delete" },
    new Object[] {"3","Monica","monica@gmail.com", "1111111111","Python","Female","Maharashtra","Delete" },
    new Object[] {"4","Kimaya","kimaya@gmail.com", "999999999","PHP","Female","Punjab","Delete" },
  };
} 
//# Username Email Mobile Course Gender State Action
}