package tableTestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TstDataProSimple {
	@Test(dataProvider="getLables")
	public void testAllTagOnAdduserPg(String uname, String mobile, String email, String course,
			String gender,String state, String pass) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();

		List<WebElement> labels = driver.findElements(By.xpath("//button//preceding::label"));

		ArrayList<String> expLabels = new ArrayList<String>();
		expLabels.add(uname);
		expLabels.add(mobile);
		expLabels.add(email);
		expLabels.add(course);
		expLabels.add(gender);
		expLabels.add(state);
		expLabels.add(pass);

		ArrayList<String> actLabels = new ArrayList<String>();
		for (WebElement label : labels) {
			String text = label.getText();
			actLabels.add(text);
		}
		Assert.assertEquals(actLabels, expLabels);
	}// testcase end

	@DataProvider // expected data comes from dataprovider(Right click package+New+others+TestngClass)
	public Object[][] getLables() {
		return new Object[][] {
				new Object[] { "Username", "Mobile", "Email", "Courses", "Gender", "State", "Password" },

		};
	}
	
	@Test(dataProvider="getLablesOnUserPg")
	public void test(String srno,String name,String email,String mob,String course,String gender
			,String state,String action){

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		ArrayList<String>actData=new ArrayList<>();
		ArrayList<String>expData=new ArrayList<>();
		expData.add(srno);
		expData.add(name);
		expData.add(email);
		expData.add(mob);
		expData.add(course);
		expData.add(gender);
		expData.add(state);
		expData.add(action);
		List<WebElement> labels = driver.findElements(By.xpath("//button//following::tr/th"));    //tr[1]/th
	for(WebElement label:labels){
		String text=label.getText();
		actData.add(text);
	}
	Assert.assertEquals(actData, expData);
	}
	@DataProvider // expected data comes from dataprovider(Right click package+New+others+TestngClass)
	public Object[][] getLablesOnUserPg() {
		return new Object[][] {
				new Object[] {"#", "Username", "Email", "Mobile", "Course", "Gender", "State", "Action" },

		};
	}
	
	@Test(dataProvider="getLablesOnOperatorPg")
	public void testOperaterPgAllTitles(String id,String person,String f,String connect,String contact,String timing){

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		ArrayList<String>actData=new ArrayList<>();
		ArrayList<String>expData=new ArrayList<>();
		expData.add(id);
		expData.add(person);
		expData.add(f);
		expData.add(connect);
		expData.add(contact);
		expData.add(timing);
		
		List<WebElement>labels=driver.findElements(By.xpath("//h3//following::tr/th"));
		for(WebElement label:labels)
		{ String text=label.getText();
			actData.add(text);
		}
		Assert.assertEquals(actData, expData);
	}
	@DataProvider 
	public Object[][] getLablesOnOperatorPg() {
		return new Object[][] {
				new Object[] {"ID", "Person", "For", "Prefered Way to Connect", "Contact", "Timings"},

		};
	}
	
	
	@Test(dataProvider="getLablesOnUsefulLinkPg")
	public void testUsefulLinkPgAllTitles(String srno,String content,String click){

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Useful Links')]")).click();
		ArrayList<String>actData=new ArrayList<>();
		ArrayList<String>expData=new ArrayList<>();
		expData.add(srno);
		expData.add(content);
		expData.add(click);
		
		List<WebElement>labels=driver.findElements(By.xpath("//h3//following::tr/th"));
		for(WebElement label:labels)
		{ String text=label.getText();
			actData.add(text);
		}
		Assert.assertEquals(actData, expData);
	}
	@DataProvider 
	public Object[][] getLablesOnUsefulLinkPg() {
		return new Object[][] {
				new Object[] {"Sr", "Content", "Click"},

		};
	}
	
	@Test(dataProvider="getLablesOnDownloadsPg")
	public void test011(String srno,String name,String vendor,String version,
			String bit32,String bit64,String common,String source){

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add(srno);
		expData.add(name);
		expData.add(vendor);
		expData.add(version);
		expData.add(bit32);
		expData.add(bit64);
		expData.add(common);
		expData.add(source);
		
		List<WebElement> labels = driver.findElements(By.xpath("//h3//following::tr/th"));    //tr/th
	for(WebElement label:labels)
	{
		String text=label.getText();
		System.out.println(text);
		 actData.add(text);
	}
		Assert.assertEquals(actData, expData);
	}
	@DataProvider
	public Object[][] getLablesOnDownloadsPg() {
		return new Object[][] {
		new Object[] {"Sr", "Name", "vendor", "Version", 
				"32bit", "64bit", "Common", "Official Source\n"
						+ "*For prevoius and latest releases" },

		};
	}
	
	
}// class ends
