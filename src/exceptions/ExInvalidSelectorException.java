package exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExInvalidSelectorException {
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement searchTextbox=driver.findElement(By.xpath("//input[@type='text'"));
		searchTextbox.sendKeys("utensils");
		//xpath syntax getting wrong
	}
}
