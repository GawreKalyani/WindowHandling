package windowGrid;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MoneyControl {
WebDriver driver;
	@Test
	public void getFirstCompanyNm(){
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com/markets/indian-indices/");
	
		WebElement fC=driver.findElement(By.xpath("//th[8]//following::a[1]"));
		System.out.println("First Name of Company found : "+fC.getText());
		
	String asianPaintVolume=driver.findElement(By.xpath("//a[contains(text(),'Paints')]//following::td[3]")).getText();
	System.out.println(asianPaintVolume);

	List<WebElement>allCompanyNm=driver.findElements(By.xpath("//td[1]"));
	for(WebElement ele:allCompanyNm)
		System.out.println(ele.getText());
	}
}
