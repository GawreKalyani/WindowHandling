package dataProvider;

import java.io.FileInputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class CExcelDataPro {
	WebDriver driver;
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
		driver.findElement(By.partialLinkText("Register")).click();
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
		String msg="User registered successfully.";
		Assert.assertEquals(al.getText(), msg);
		al.accept();
	}
	 @DataProvider
	  public Object[][] rrData() throws Exception 
	 {
		 FileInputStream fis=new FileInputStream("Book1.xls");
		 Workbook wb=Workbook.getWorkbook(fis);
		 Sheet sh=wb.getSheet("reg");
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
	 
	 @Test(priority=2)
		public void addUser(){
			driver.findElement(By.partialLinkText("I")).click();
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			driver.findElement(By.xpath("//span[text()='Users']")).click();
			driver.findElement(By.xpath("//button[text()='Add User']")).click();
				
		}
		@Test(dataProvider = "addUserData",priority=3)
		public void test02(String name,String uname,String mob, String courses,String gender,String selectstate,String pass) {
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(name);
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys(mob);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(uname);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(pass);
			driver.findElement(By.id("course")).clear();
			driver.findElement(By.id("course")).sendKeys(courses);
			
			WebElement femaleradio=driver.findElement(By.id("Female"));
			WebElement maleradio=driver.findElement(By.id("Male"));
			if(gender.equals("Male"))
				maleradio.click();
				else
					femaleradio.click();
			
			Select state=new Select(driver.findElement(By.tagName("select")));
			state.selectByVisibleText(selectstate);
			
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			Alert al=driver.switchTo().alert();
			String textmsg="User Added Successfully. You can not see added user.";
			Assert.assertEquals(al.getText(), textmsg);
			al.accept();
		}
		 @DataProvider
		  public Object[][] addUserData() throws Exception 
		 {
			 FileInputStream fis=new FileInputStream("register.xls");
			 Workbook wb=Workbook.getWorkbook(fis);
			 Sheet sh=wb.getSheet("user");
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
