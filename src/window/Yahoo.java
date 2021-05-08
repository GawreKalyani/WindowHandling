package window;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Yahoo {

	WebDriver driver;

	@Test
	public void yahooNews(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://in.yahoo.com/");
		driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement>news=driver.findElements(By.xpath("//li[@data-test-locator='tnitem']"));
		for(WebElement ele:news){
			String text=ele.getText();
			System.out.println(text);
		}
	}
}

/* driver.findElement(By.xpath("//span[contains(text(),"+i+"."+")]//following-sibling::span"));       
1. COVID-19 in India
2. Anil Deshmukh
3. Ajit Singh
4. Tejasvi Surya
5. Tathagata Roy
6. Stock market today
7. Dalip Tahil
8. Abhilasha Patil
9. West Bengal violence
10. V. Muraleedharan
                     */
