package window;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	@Test
	public void datePicker()throws Exception{
		String year="2021";
		String month="July";
		String date ="28";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		WebElement textbox=driver.findElement(By.id("onward_cal"));
		textbox.click();           //put cursor in textbox
		Thread.sleep(2000);
		while(true)
		{												// April 2021 ---month Title
			String monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText()	;
				
				String dataArr[]=monthyear.split(" ");
				String mon=dataArr[0];
				String yr=dataArr[1];
				
			if(mon.equalsIgnoreCase(month)&& yr.equalsIgnoreCase(year))
				break;
			else 
				driver.findElement(By.xpath("//button[text()='>']")).click(); //next arrow
			
		}
		List<WebElement>alldates=driver.findElements(By.xpath("//th//following::td"));
		for(WebElement e:alldates)
		{
			String dt=e.getText();
			if(dt.equals(date))
			{
				e.click();
				break;
			}
		}

}
	@Test
	public void fromToInRedbus()throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		WebElement from=driver.findElement(By.id("src"));
		from.sendKeys("Pune");
		
		from.sendKeys(Keys.TAB);
		
		WebElement toDesti=driver.findElement(By.id("dest"));
		toDesti.sendKeys("Nagpur");
		
		toDesti.sendKeys(Keys.TAB);
		
		WebElement textbox=driver.findElement(By.id("onward_cal"));
		textbox.sendKeys("30May2021");          //but date is not observed in textbox
		Thread.sleep(2000);
		}
	
	@Test
	public void datePickerInRedBus()throws Exception{
		String month="May 2022";
		String date ="28";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		WebElement textbox=driver.findElement(By.id("onward_cal"));
		textbox.click();           //put cursor in textbox
		Thread.sleep(2000);
		while(true)
		{
				String text=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText()	;
			if(text.equals(month))
				break;
			else
			driver.findElement(By.xpath("//td[@class='next']//child::button")).click();
		}
		driver.findElement(By.xpath("//td[text()='"+date+"']")).click();

}

}

