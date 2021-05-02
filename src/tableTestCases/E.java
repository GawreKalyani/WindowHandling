package tableTestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class E {
	@Test
	public void testNameFor32bitButton(){
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
       

        ArrayList<String> actData = new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		
        List<WebElement> names= driver.findElements(By.xpath("//td[5]"));
		int i=2;
		for(WebElement name : names) {
			if(name.getText().equals("32bit")) {
				String vendor = driver.findElement(By.xpath("//tr["+i+"]/td[3]")).getText();
				
				System.out.println(vendor);
				actData.add(vendor);
			}
			i++;
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
	public void common(){

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();	
		
		int i=2;
	       List<WebElement>commonCol=driver.findElements(By.xpath("//td[7]"));
	      
	     ArrayList<String> actData = new ArrayList<String>();
			ArrayList<String> expData = new ArrayList<String>();
			expData.add("Selenium Server Standalon Jar");
			expData.add("Selenium Server Source Jar");
			expData.add("Google Chrome Driver");
		
		 for(WebElement element:commonCol)
		 {
	    	   String text=element.getText();
	    	  
	    	   if(text.equals("Common")||text.contains("2.52.0"))
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
	public void testVersionGetName(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		
		 ArrayList<String> actData = new ArrayList<String>();
			ArrayList<String> expData = new ArrayList<String>();
			expData.add("Google Chrome");
			expData.add("Google Chrome Driver");
		
		List<WebElement>version=driver.findElements(By.xpath("//td[4]"));
		List<WebElement>vendorNms=driver.findElements(By.xpath("//td[3]"));
	int i=0;	
		for(WebElement element:version){
			String text=element.getText();
			if(text.contains("76.0")){
				String vendor=vendorNms.get(i).getText();
				System.out.println(vendor);
				actData.add(vendor);
			}
			i++;
		}
		Assert.assertEquals(actData, expData);
	}
	@Test
	public void testOfficialWebsitebtnCol(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		 	ArrayList<String> actData = new ArrayList<String>();
			ArrayList<String> expData = new ArrayList<String>();
			expData.add("Java Development Kit (JDK)");
			expData.add("Selenium Server Standalon Jar");
			expData.add("Selenium Server Source Jar");
			expData.add("Google Chrome");
			expData.add("Google Chrome Driver");
			expData.add("Mozilla Firefox");
			expData.add("Gecko Driver for Latest firefox");
		List<WebElement>offsource=driver.findElements(By.xpath("//td[8]"));
		List<WebElement>vendorNms=driver.findElements(By.xpath("//td[3]"));
	int i=0;	
		for(WebElement element:offsource){
			String text=element.getText();
			if(text.contains("Official Website"))
			{
				String vendor=vendorNms.get(i).getText();
				System.out.println(vendor);
				actData.add(vendor);
	
			}
			i++;
		}
		Assert.assertEquals(actData, expData);
	}
	@Test
	public void verifyDownloadsCommonBlank() {
		int i = 2;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		List<WebElement> commonColnames = driver.findElements(By.xpath("//td[7]"));// all
		for (WebElement ele : commonColnames) 
		{
			String text=ele.getText();
			if (text.equals(""))
			{
				String name=driver.findElement(By.xpath("//tr["+i+"]/td[3]")).getText();
				System.out.println(name);
				actData.add(name);
			}
			i++;
		}
		Assert.assertEquals(actData, expData);
	}
	
	
}
