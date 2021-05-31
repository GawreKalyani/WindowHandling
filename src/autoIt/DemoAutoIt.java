package autoIt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoAutoIt {
@Test
public void teest(){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("file:///D:/selenium/AutoIt/Auto.html");
	driver.manage().window().maximize();
	driver.findElement(By.id("input")).click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	try {
		Runtime.getRuntime().exec("D:\\selenium\\AutoIt\\sorting.exe");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
//selenium 3.141.59
//chromedriver 2.44

}
}
/*ControlFocus("Open", "", "Edit1")
ControlSetText("Open", "", "Edit1","E:\AutoIT\abc.txt")
ControlClick("Open", "", "Button1")
//Runtime.getRuntime().exec("D:\\Auto\\demo.exe");
*/
