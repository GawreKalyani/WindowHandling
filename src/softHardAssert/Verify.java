package softHardAssert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Verify {
WebDriver driver;
SoftAssert as;

	@BeforeMethod
	public void setup(){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://www.google.com");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	@Test
	public void softAss(){
		 as=new SoftAssert();
		String currentUrl="https://www.google.com/12";
		String title="Google1";
		as.assertEquals(driver.getTitle(), title);
		as.assertAll();
		as.assertEquals(driver.getCurrentUrl(), currentUrl);
		
	}
	@Test(priority=1)
	public void softAssEx(){
		 as=new SoftAssert();
		String currentUrl="https://www.google.com/12";
		String title="Google1";
		as.assertEquals(driver.getTitle(), title);
		as.assertEquals(driver.getCurrentUrl(), currentUrl);
		as.assertAll();

		
	}
}
