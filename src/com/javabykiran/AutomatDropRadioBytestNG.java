package com.javabykiran;
//Automation of Dropdown/Radio button using TestNG
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class AutomatDropRadioBytestNG {
	
@Test	
public void testDropdown()
{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();//open browser
	
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
//Step1)Object create karo of class Select	
	Select state=new Select(driver.findElement(By.xpath("//select")));//xpath of select  of dropdown
//IMport:select (org.openqa.selenium.WebElement)
	
//step2) use selectByValue method(Orange text)		

	state.selectByValue("Maharashtra");
	state.selectByValue("Delhi");
	state.selectByValue("HP");
	state.selectByValue("Punjab");

//step3)Use getOptions();
	System.out.println("state>>>"+state.getOptions());

List<WebElement>ListOfOption=state.getOptions();//IMPoRT:For List:java.util.List; For Webelement:org.openqa.selenium

//for each loop me Use getText();
	for(WebElement option:ListOfOption)
	{
		String op1=option.getText();

		System.out.println("Print state name"+op1);
	}
}
@Test
public void testRadioBtton()
{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();//open browser

driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
	WebElement male=driver.findElement(By.id("Male"));
	boolean maleRadio =male.isDisplayed();
	System.out.println("male is displayed"+maleRadio);
	
	WebElement female=driver.findElement(By.id("Female"));
	boolean femaleRadio =female.isDisplayed();
	System.out.println("female is displayed"+femaleRadio);

}
}
