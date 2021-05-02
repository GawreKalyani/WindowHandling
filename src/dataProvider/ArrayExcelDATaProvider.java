package dataProvider;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class ArrayExcelDATaProvider {
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
	}
	
	
	@Test(dataProvider = "loginData")
	public void test01(String uname, String pass) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		if(driver.getTitle().equals("JavaByKiran | Dashboard"))
			driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a")).click();
	//log out button click
	}
	
	@DataProvider
	  public Object[][] loginData() throws Exception{
		  	FileInputStream fis = new FileInputStream("Book1.xls");	
			Workbook wb= Workbook.getWorkbook(fis);
			Sheet sh = wb.getSheet("login");
			int row=sh.getRows();
			int col=sh.getColumns();
			String dataArr[][]= new String[row-1][col];
			for(int i=1;i<row;i++) {
				for(int j=0;j<col;j++) {
					String data=sh.getCell(j,i).getContents();	
					dataArr[i-1][j]=data;
				}
			}
			return dataArr; //return of DataProvider method
			
	  }//terminte DataProvider method

}//terminate main method


//Rename Sheet 1 as login
//In dataprovider,return type of method is Two Dimensional Array ex Object[][]
//throw Exception
//Excel sheet ka data store karna padega Array me say   String dataArr[][]
//String dataArr[][]= new String[sh.getRows()-1][sh.getColumns()];
//loop
//array me data stored by index 0 ,so dataArr[i-1][j]=data;
//Method has return type,so return sttm must be given here ex return dataarray