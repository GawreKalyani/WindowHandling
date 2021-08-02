package windowGrid;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
	driver.get("http://www.zlti.com");

      List<WebElement> links = driver.findElements(By.tagName("a"));
    System.out.println(links.size());
    
    for(int i=0;i<links.size();i++){
    	String url=links.get(i).getAttribute("href");
    	
    	URL link=new URL(url);
    	HttpURLConnection httpConn=(HttpURLConnection)link.openConnection();
    	httpConn.connect();
    	//httpConn.setRequestMethod("HEAD");
    	int responseCode=httpConn.getResponseCode();
    	if(responseCode>=400)
    	{
    		System.out.println(url+" is a broken link");
    	}
    	else
    		System.out.println(url+" is a valid link");
    }

}
}
