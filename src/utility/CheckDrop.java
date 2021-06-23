package utility;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class CheckDrop {
public static WebDriver driver;
		public static void testCheckbox(List<String>strings,List<WebElement>elements){
			for(String s:strings)
			{
					for(WebElement element:elements)
					{
						if(element.getAttribute("value").equals(s))
						{
							element.click();
							break;
						}
					}
			}
		}
public static void testCheckbox(String []array,List<WebElement>elements){
			for (String s : array) {
					for(WebElement element:elements)
					{
						if(element.getAttribute("value").equals(s))
						{
							element.click();
							break;
						}
					}
			}
		}
	
		public static void radioButton(String text,List<WebElement>elements){

			for(WebElement ele:elements)
			{
				if(ele.getAttribute("value").equals(text))
				{
					ele.click();
					break;
				}
			}
		}
		public static void dropDown(String text,WebElement element){
			Select s=new Select(element);
			s.selectByVisibleText(text);
		}
		public static void mutiselectDropDown(List<String>options,WebElement ele){
			Select s=new Select(ele);
			if(s.isMultiple())
			{
				for(String option:options)
				s.selectByVisibleText(option);
			}
		}
		public static void sendkeys(WebElement element,String text){
			element.clear();
			element.sendKeys(text);
		}
		
		public static void click(WebElement element){
			element.click();
		}
	
}
