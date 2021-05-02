package window;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Yahoo {

	WebDriver driver;

	@Test
	public void yahooNewsTest()throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.yahoo.com/");
		Thread.sleep(10000);
		for(int i=1;i<=10;i++) {
			String xpath ="//span[contains(text(),'"+i+"')]//following-sibling::span]";
			System.out.println(xpath);
			WebElement news = driver.findElement(By.xpath(xpath));
		
			System.out.println(news.getText());
		}
		
	}
}

/* driver.findElement(By.xpath("//span[contains(text(),"+i+"."+")]//following-sibling::span"));       
 *  COVID-19 in India
           Narendra Modi
           Lalu Prasad Yadav
           Nambi Narayanan
           Nawab Malik
           DSP mutual fund
           Deep Sindhu
           Sonu Sood
           Vinesh Phogat
            IPL 2021           */
