package dataProvider;
import java.io.FileInputStream;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
//If we want to test case 1 and 3,then case2 write (enabled=false);we get result of case1 and case2
//@Test(dataprovider="NmOfMethod",priority=1)
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;

public class RegisterExcel {
		WebDriver driver;
		
	@BeforeSuite
	public void registerPg(){
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	    driver.findElement(By.partialLinkText("Register a new membership")).click();
	}
	@Test(dataProvider="rrData")
	public void testReg(String names,String mob,String email,String pass)
	{
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(names);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mob);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		Alert al=driver.switchTo().alert();
		Assert.assertEquals(al.getText(), "User registered successfully.");
		al.accept();
	}
	 @DataProvider
	  public Object[][] rrData() throws Exception 
	 {
		 FileInputStream fis=new FileInputStream("register.xls");
		 Workbook wb=Workbook.getWorkbook(fis);
		 Sheet sh=wb.getSheet("registerData");
		 int row=sh.getRows();
		 int col=sh.getColumns();
		 String[][]arr=new String[row-1][col];
			 for (int i = 1; i < row; i++)
			 {
				for (int j = 0; j < col; j++) 
				{
					String data=sh.getCell(j, i).getContents();
					arr[i-1][j]=data;
				}
			}
		    return arr ;
	 	}
	}
	

