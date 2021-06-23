package com.javabykiran;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class RadioDropDown {
	//Automation of dropdown(select--option) and radio button
	public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver=new ChromeDriver();//open browser
		
	driver.get("file:///E:/Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
		
		//For Dropdown box(States)
	//step1)Select class ka object create karo
		Select state=new Select(driver.findElement(By.xpath("//select")));//xpath of select  of dropdown
	//IMport:select (org.openqa.selenium.WebElement)
		
	//step2) use selectByVisibleText(Black text) or selectByValue method(Orange text)	
		state.selectByVisibleText("Maharashtra");	
		state.selectByVisibleText("Delhi");	
		state.selectByVisibleText("HP");	
		state.selectByVisibleText("Punjab");	

		state.selectByValue("Maharashtra");
		state.selectByValue("Delhi");
		state.selectByValue("HP");
		state.selectByValue("Punjab");

	//step3)Use getOptions();
		System.out.println("state>>>"+state.getOptions());

	List<WebElement>ListOfOption=state.getOptions();//IMPoRT:For List:java.util.List; For Webelement:org.openqa.selenium

	//for each loop mee Use getText();
		for(WebElement option:ListOfOption)
		{
			String op1=option.getText();

			System.out.println("Print state name"+op1);
		}
	//Radio Button
	//3 method:isDisplayed(),isEnabled(),isSelected:Use any one
	//For Male
		WebElement male=driver.findElement(By.id("Male"));
		boolean maleRadio =male.isDisplayed();
		System.out.println("male is displayed"+maleRadio);

		boolean maleRadio1 =male.isEnabled();
		System.out.println("male is displayed"+maleRadio1);

		male.click();
		if(male.isSelected())
		{
			System.out.println("male is selected");
		}
		else
		{
			System.out.println("male not selected");
		}
	//For Female Radio button
		WebElement female=driver.findElement(By.id("Female"));
		boolean femaleRadio =female.isDisplayed();
		System.out.println("female is displayed"+femaleRadio);

		boolean femaleRadio1 =female.isEnabled();
		System.out.println("female is displayed"+femaleRadio1);

		female.click();
		if(female.isSelected())
		{
			System.out.println("female is selected");
		}
		else
		{
			System.out.println("male is selected");
		}
		
		}
	}


