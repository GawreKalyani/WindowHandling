package locators8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Csss {
	WebDriver driver;

	@Test(priority=1)
	public void testCssselecteor(){
//		1. Tag and Id
				//syntax--- tagName#id
				driver.findElement(By.cssSelector("input#email"));
				
				//  2. tag and class
				
				//syntax--- tagName.class
				WebElement abc=driver.findElement(By.cssSelector("p.login-box-msg"));
				
				WebElement sel_box =driver.findElement(By.className("small-box bg-aqua"));
				
				sel_box.getCssValue("background-color");
				
				
				abc.getCssValue("display");//block
				
				//3. Tag and Attributes
				
				//syntax---  tagName[attribute=value]
				
				driver.findElement(By.cssSelector("input[placeholder=Email]"));
						
				// 4. tag class and attribute
				
				//syntax---  tagName.class[attribute=value]
				
				driver.findElement(By.cssSelector("input.form-control[placeholder=Email]"));
				
				//5 tag and inner text
				
				//syntax-- tag:contains("text")
				
				driver.findElement(By.cssSelector("p:contains('Kiran')"));
				
				
				
/*    1.Tag and Id          Tagname#idVal                        input#email
	 2.Tag And Class       TagName.classVal                      p.login-box-msg
	 3.Tag and Attribute    Tagname[attr=attrVal]               input[placeholder=Email]
 4. tag class and attribute   tagName.class[attribute=value]     input.form-control[placeholder=Email]              
 5. tag and inner text        tag:contains("text")                  p:contains('Kiran')                              */
	}
}
