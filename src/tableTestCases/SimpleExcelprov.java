package tableTestCases;

import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;

public class SimpleExcelprov {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public static WebDriver initialization()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		return driver;
	}
	
	@Test(dataProvider="getLogin")
	public void test111(String email,String pass,String title){

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		
		Assert.assertEquals(driver.getTitle(),title);
		
		if(title.contains("Dashboard")){
			driver.findElement(By.partialLinkText("LOGOUT")).click();
		}
		
	}
	@DataProvider
	public Object[][] getLogin() {
		return new Object[][] {
		  new Object[] { "kiran@gmail.com","123456" ,"JavaByKiran | Dashboard"},
	      new Object[] { "mangesh@gmail.com", "qwerty","JavaByKiran | Log in" },
	      new Object[] { "neelam@gmail.com",  "m123456","JavaByKiran | Log in" },

		};
	}
	
	@Test(dataProvider="getExcelLogin")
	public void excelLoginCheckTitle(String email,String pass){
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		if(driver.getTitle().equals("JavaByKiran | Dashboard")){
			Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
			driver.findElement(By.partialLinkText("LOGOUT")).click();
		}
	
      else{
    	  Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
      	}
	}
	@DataProvider
	public Object[][] getExcelLogin() throws Exception {
		FileInputStream fis=new FileInputStream("register.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet("login");
		int rows=sh.getRows();
		int cols=sh.getColumns();
		String [][]data=new String[rows-1][cols];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				String text=sh.getCell(j, i).getContents();
				data[i-1][j]=text;
			}
		}
		return data;
		
	}
	
	
}
