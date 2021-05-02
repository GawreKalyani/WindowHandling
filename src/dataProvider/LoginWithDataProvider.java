package dataProvider;
//Select Package-Rightclick--New--Other-Wizard(Write TestNG)-WeGEt select TESTNG Class--Next
//--Give ClassName,right mark to @DataProvider then Finish
//(String emailid, String pass) provide email sendKeys as emailid and 
//password sendKeys as pass
//Email and Password in String;Pass as argument
//Give mthod nm to dataProvider ex(dataProvider = "loginData"),public Object[][] loginData()
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class LoginWithDataProvider {
	
  @Test(dataProvider = "loginData")
  public void test01(String emailid, String pass) 
  {
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser	
		driver.findElement(By.id("email")).sendKeys(emailid);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
  }

  @DataProvider
  public Object[][] loginData() {
    return new Object[][] {
      new Object[] { "kiran@gmail.com", "123456" },
      new Object[] { "mangesh@gmail.com", "qwerty" },
      new Object[] { "neelam@gmail.com", "3455jj" },
      new Object[] { "kieeran@gmail.com", "123dd456" },
    };
  }
}
