package actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NaukriSite {
//List comes:use there moveToElement()
	@Test
	public void test1(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		WebElement company=driver.findElement(By.xpath("//div[text()='Companies']"));
		Actions action=new Actions(driver);
		action.moveToElement(company).perform();
		
		WebElement aboutcompany=driver.findElement(By.xpath("//a[text()='About Companies']"));
		action.moveToElement(aboutcompany).click().build().perform();
		
	}
}
