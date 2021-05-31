package tableTestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class B {
	@Test
	public void verifyUsersTableSrno() 
	{
		int expectedText=1;
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
	List<WebElement> userId =driver.findElements(By.xpath("//tr/td[1]"));// 4 elementOFSr 1 2 3 4 
	
	for(WebElement element:userId)           //element iterate in loop one by one
	{
		String data=element.getText();      	//"1"
		int actualText=Integer.parseInt(data);        //1    Converting String into Integer
		Assert.assertEquals(actualText, expectedText);
		expectedText++;                           // 2 3 4
	}

}
	
	@Test
	public void testMob(){      //fails as there is 2 mobno of 9 digit and 2mobno of 10 digit
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		
	SoftAssert sa=new SoftAssert();//helps to executes other statement after exception occurs(failure)
	
	List<WebElement> mobiles =driver.findElements(By.xpath("//tr/td[4]"));// 4 elementOFMobno 
	for(WebElement element:mobiles)
	{
		String text=element.getText();
		
		int noOfDigit=text.length();
		
		sa.assertEquals(noOfDigit, 10);
	}	
	sa.assertAll();
}
	@Test
	public void verifyEmail() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
		List<WebElement> emails =driver.findElements(By.xpath("//tr/td[3]"));// 4 element
	
	for(WebElement element :emails) 
	{
		 String text =element.getText();
		boolean flag=text.contains("@gmail.com");
		 Assert.assertEquals(flag ,true);  //contains() return type boolean here two boolean values are checked
	}

   }//testcase3 end
	
	
	@Test
	public void CheckNamesForStateMahrashtra(){

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
		for(WebElement element:states)
		{
			String text=element.getText();
			
			if(text.equals("Maharashtra"))
			{   String name=unames.get(i).getText();
				System.out.println(name);
				boolean flag=name.equals("Kiran")||name.equals("Monica");
				Assert.assertTrue(flag);
			}
			i++;
		}
	}
	
	@Test 
	public void Verify_Teacher_Name_Not_Present_on_Sunday()
	{	
		int i=0 ;
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		
		List<WebElement> timing =driver.findElements(By.xpath("//tr/td[6]"));
		List<WebElement> person =driver.findElements(By.xpath("//tr/td[2]"));
		
		ArrayList <String>actData = new ArrayList <>();
		
		ArrayList <String>expData = new ArrayList <>();
		expData.add("Neelam");
		expData.add("Seema");
		
		System.out.println("Faculties not available on Sunday : ");
		
		for (WebElement element : timing)
		{
			String days = element.getText();
			
			if (!days.contains("Sunday"))
			{
				String faculty = person.get(i).getText();
				System.out.println(faculty);
				actData.add(faculty);
			}
			i++ ;
		}
		Assert.assertEquals(actData, expData);
	}
	
	@Test
	public void vendorNameFor64bitButton(){

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
	int i=2;
       List<WebElement>bit64column=driver.findElements(By.xpath("//td[6]"));

       ArrayList<String> actData = new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		
       for(WebElement element:bit64column){
    	   String text=element.getText();
    	   if(text.equals("64bit"))
    	   {
    		  String vendor=driver.findElement(By.xpath("//tr["+i+"]/td[3]")).getText(); 
    		  System.out.println(vendor);
    		  actData.add(vendor);
    	   }
    	   i++;
       }
       Assert.assertEquals(actData, expData);
	}
	
	@Test
	public void SortingNames(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();	
		List<WebElement>names=driver.findElements(By.xpath("//td[2]"));
		/*for(WebElement ele:names){
			String y=ele.getText();
		}
*/	}
	
	
	
	
	
}
