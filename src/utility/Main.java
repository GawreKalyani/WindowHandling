package utility;

import java.awt.AWTException;
import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Main {
	WebDriver driver;
	
	@BeforeSuite 
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");	
	}
	
	@Test(priority=1)
	public void Radio(){
	CheckDrop.radioButton("Male",driver.findElements(By.xpath("//input[@ng-model='radiovalue']")));
	}
			
	@Test(priority=2)
	public void selectMultipleCheckbox(){
	ArrayList<String>strings=new ArrayList<>();	//multipleOptions (out of 3 option,2 option selected)
	strings.add("Movies");
	strings.add("Hockey");
	CheckDrop.testCheckbox(strings,driver.findElements(By.xpath("//input[@type='checkbox']")));			
	}
	
	@Test(priority=3)
	public void checkbox1(){
		String array[]={"Cricket","Hockey"};
	List<String>list=Arrays.asList(array);
	CheckDrop.testCheckbox(list,driver.findElements(By.xpath("//input[@type='checkbox']")));			
	 }
		/*	
			String a[]= new String[] { "A", "B", "C", "D" };
			// getting the list view of Array
			  List<String> list = Arrays.asList(a);
			   // printing the list
            System.out.println("The list is: " + list);
			*/
	@Test
	public void dateOfBirth() throws Exception{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");//scroll full down
		
		CheckDrop.dropDown("1934", driver.findElement(By.id("yearbox")));
		Thread.sleep(2000);
		CheckDrop.dropDown("March",driver.findElement(By.xpath("//select[@ng-model='monthbox']")));
		Thread.sleep(2000);
		CheckDrop.dropDown("21",driver.findElement(By.xpath("//select[@placeholder='Day']")));
	}
	@Test
	public void addreess(){
		CheckDrop.sendkeys(driver.findElement(By.xpath("//textarea")),"Gurukunj Nagar");
	}
	@Test
	public void lan(){
		ArrayList<String>lan=new ArrayList<>();
		lan.add("Catalan");
		lan.add("Dutch");
		CheckDrop.mutiselectDropDown(lan, driver.findElement(By.xpath("//div[@id='msdd']")));
	}
	@Test
	public void tsbsb(){
		List<WebElement>e=driver.findElements(By.xpath("//div[@class='ui-autocomplete-multiselect-item']"));
		
		for (WebElement w : e) {
			String text=w.getText();
			System.out.println(text);
		}
	}
	@Test
	public void toptions(){
		Select s=new Select(driver.findElement(By.id("country")));
		List<WebElement>e=s.getOptions();
	/*	for (WebElement w : e) {
			System.out.println(w.getText());
		}*/
		int u=e.size();
		System.out.println(u);
	}
	@Test
	public void test() throws AWTException, InterruptedException{
		driver.findElement(By.xpath("//select[@id='Skills']")).click();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	
}
