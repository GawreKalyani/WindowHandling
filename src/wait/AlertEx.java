package wait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertEx {
	@Test
	public void test01() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click(); //Users xpath
		
		driver.findElement(By.xpath("//tr[2]/td[8]")).click();	//Delete Button
		Thread.sleep(5000);
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText()); //text in pop up alertbox //You can not delete Default User
		al.accept();
	}
}
