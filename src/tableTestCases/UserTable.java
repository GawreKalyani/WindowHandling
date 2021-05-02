package tableTestCases;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class UserTable {
int i=0;
	
	@Test(dataProvider = "dp")
	  public void usersTable_1(String a,String b,String c,String d,String e,String f,String g,String h) 
	  {
		  	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
			driver.manage().window().maximize();
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
	  
			driver.findElement(By.xpath("//span[text()='Users']")).click();
			
			List<WebElement> row1 =driver.findElements(By.xpath("//tr/th"));
			List<WebElement> row2 =driver.findElements(By.xpath("//tr[2]/td"));
			List<WebElement> row3 =driver.findElements(By.xpath("//tr[3]/td"));
			List<WebElement> row4 =driver.findElements(By.xpath("//tr[4]/td"));
			List<WebElement> row5 =driver.findElements(By.xpath("//tr[5]/td"));
			
			ArrayList <String>actData = new ArrayList <>();
			
			ArrayList <String>expData = new ArrayList <>();
			expData.add(a);
			expData.add(b);
			expData.add(c);
			expData.add(d);
			expData.add(e);
			expData.add(f);
			expData.add(g);
			expData.add(h);
			
			if(i==0)
			{
				for (String element_1 : expData)
				{
					System.out.println(element_1);
				}
				
				for (WebElement element : row1)
				{
					String data = element.getText();
					System.out.println(data);
					actData.add(data);
				}
			}
			else if(i==1)
			{
				for (String element_1 : expData)
				{
					System.out.println(element_1);
				}
				
				for (WebElement element : row2)
				{
					String data = element.getText();
					System.out.println(data);
					actData.add(data);
				}
			}
			else if(i==2)
			{
				for (String element_1 : expData)
				{
					System.out.println(element_1);
				}
				
				for (WebElement element : row3)
				{
					String data = element.getText();
					System.out.println(data);
					actData.add(data);
				}
			}
			else if(i==3)
			{
				for (String element_1 : expData)
				{
					System.out.println(element_1);
				}
				
				for (WebElement element : row4)
				{
					String data = element.getText();
					System.out.println(data);
					actData.add(data);
				}
			}
			else 
			{
				for (String element_1 : expData)
				{
					System.out.println(element_1);
				}
				
				for (WebElement element : row5)
				{
					String data = element.getText();
					System.out.println(data);
					actData.add(data);
				}
			}
			
			i++;
			
			Assert.assertEquals(actData, expData);
	  }
	
	@DataProvider
	  public Object[][] dp() throws Exception
	  {
		FileInputStream fis = new FileInputStream("register.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		  Sheet sh = wb.getSheet("userfulldata");
		  String data[][] = new String [sh.getRows()][sh.getColumns()];
		  
		  for (int i=0 ; i<sh.getRows() ; i++)
			{
				for(int j=0 ; j<sh.getColumns() ; j++)
				{
					Cell cell = sh.getCell(j, i);
					data [i][j] = cell.getContents();
				}
			}
	    return data ;  
	  }
}
