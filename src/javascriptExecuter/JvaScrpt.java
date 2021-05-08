package javascriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JvaScrpt {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println(js.executeScript("return document.URL;"));
		System.out.println(js.executeScript("return document.title;"));
		js.executeScript("document.title='Geet';");
		System.out.println(js.executeScript("return document.title;"));
		WebElement email = driver.findElement(By.id("email"));
		js.executeScript("arguments[0].click()", email);
		js.executeScript("document.getElementById('email').value='kiran@gmail.com';");
		js.executeScript("alert('Ready to Email');");
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		Thread.sleep(2000);
		al.accept();
		WebElement pass = driver.findElement(By.id("password"));
		js.executeScript("arguments[0].click()", pass);
		js.executeScript("document.getElementById('password').value='123456';");
	//js.executeScript("document.getElement(By.xpath('//input[@id='password']')).value='123456';");	
		WebElement signIn = driver.findElement(By.xpath("//button"));
		js.executeScript("arguments[0].click()", signIn);
		js.executeScript("alert('GoodMorning');");
		Alert al1 = driver.switchTo().alert();
		System.out.println(al1.getText());
		Thread.sleep(3000);
		al1.accept();
	}
}
