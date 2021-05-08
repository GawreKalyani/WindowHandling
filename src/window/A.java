package window;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class A {
@Test
public void test01() {
		
		Set <String> expNewWindowUrls = new HashSet <String>();
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/java-j2ee-syllabus-jbk.pdf");		
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/python-syllabus.pdf");
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/dashboard.html#");

		Set <String> actNewWindowUrls = new HashSet <String>();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		
				driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");// entering a text in to text box
				driver.findElement(By.id("password")).sendKeys("123456");
				driver.findElement(By.xpath("//button")).click();
				String mainWindow= driver.getWindowHandle();
				List<WebElement>links = driver.findElements(By.partialLinkText("More"));
				for(WebElement link : links) {
					link.click();// 5 wins are opened
				}
				Set<String> wins= driver.getWindowHandles();
				for(String name: wins) {
					if(!name.equals(mainWindow)) {
						driver.switchTo().window(name);
						actNewWindowUrls.add(driver.getCurrentUrl());
					}
				}
				Assert.assertEquals(actNewWindowUrls, expNewWindowUrls);
}

@Test(dataProvider = "loginData", enabled=false)
public void user(String sr, String name, String  email, String mobile, 
		String course, String gender, String state, String action){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();// browser open
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.manage().window().maximize();
	ArrayList<String> expData = new ArrayList<String>();
	expData.add(sr);
	expData.add(name);
	expData.add(email);
	expData.add(mobile);
	expData.add(course);
	expData.add(gender);
	expData.add(state);
	expData.add(action);
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");// entering a text in to text box
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			driver.findElement(By.xpath("//span[text()='Users']")).click();
			ArrayList<String> actData = new ArrayList<String>();
			List<WebElement>table=driver.findElements(By.xpath("//table"));
			for(WebElement ele:table){
				String text=ele.getText();
				System.out.println(text);
				actData.add(text);
			}
			Assert.assertEquals(actData, expData);
}
@DataProvider
public Object[][] loginData() throws Exception{
	  	FileInputStream fis = new FileInputStream("Book1.xls");	
		Workbook wb= Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("user");
		int row=sh.getRows();
		int col=sh.getColumns();
		String dataArr[][]= new String[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				String data=sh.getCell(j,i).getContents();	
				dataArr[i][j]=data;
			}
		}
		return dataArr; //return of DataProvider method
		
}//terminte DataProvider method

}
