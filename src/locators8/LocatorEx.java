package locators8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorEx {
public static void main(String[] args) {
	System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	
	//Locators:Are use to find webElements on web page.we have 8 locators in selenium
	//id,name,tagName,className,linkText,partialLinkText,xpath,css selector

//Inspect Email TextBox--select completeTag--Clt+F--to write xpath
//<input type="text" id="email" class="form-control" placeholder="Email">	Email TextBox 
	
driver.findElement(By.id("email"));	//id is always unique 1 out of 1  

//multiple element chances,so not used 
driver.findElement(By.name("viewport"));      //meta[@name='viewport']  1 out of 1
driver.findElement(By.tagName("button"));			//button[@type='submit']  1 out of 1
driver.findElement(By.className("form-control"));//1 out of 2 Email TextBox   //input[@class='form-control']

//Used for Hyperlink(Blue color Text) Register a new membership
//<a href="pages/examples/register.html"class="text-center">Register a new membership
driver.findElement(By.linkText("Register a new membership")); //a[@href='pages/examples/register.html']
driver.findElement(By.partialLinkText("new"));

//Xpath has two types
//1.Absolute xpath:Starts with one slash /	:not used in company
//2.Relative xpath:Starts with two slash //  used in company

//Standard Syntax for Relative xpath(Method 1)     //Tagname[@ attributeName='attributeValue']
driver.findElement(By.xpath("//input[@id='email']"));//relative xpath for Email textbox	
driver.findElement(By.xpath("//a[@href='pages/examples/register.html']"));	//hyperlink Register a new membership
driver.findElement(By.xpath("//button[@type='submit'] "));	//For sign in button

driver.findElement(By.xpath("//tr[3]/td[4]"));//For User Table Row3 MOBNO 999999999
driver.findElement(By.xpath("//tr[3]/td[4]/span[2]"));//Operator table Row3 Phonecall blue button
driver.findElement(By.xpath("//tr[1]/th[2]"));//Operator table Row1 tableheading Person

//tags that dont have attributes,then use text()
//<b>Java By Kiran</b>; <h4>JAVA | SELENIUM | PYTHON </h4>;
//<p class="login-box-msg">Sign in to start your session</p>

//Syntax for Relative xpath(Axes 1)	//Tagname[text()='TextContent']
driver.findElement(By.xpath("//b[text()='Java By Kiran']"));
driver.findElement(By.xpath("//h4[text()='JAVA | SELENIUM | PYTHON']"));
driver.findElement(By.xpath("//p[text()='Sign in to start your session']"));

//Syntax for Relative xpath(Axes 2) //Tagname[contains(func/attr,'partialValue')]

// //Tagname[contains(text(),'partialTextContent')]  //Tagname[contains(attribute,'partialattributeValue')]
//partial:not complete text,more than one character(substring)
//For tag <p class="login-box-msg">Sign in to start your session</p>
//<input type="text" id="email" class="form-control" placeholder="Email">	Email TextBox 
driver.findElement(By.xpath("//p[contains(text(),'start')]"));  
driver.findElement(By.xpath("//p[contains(@class,'login')]"));
driver.findElement(By.xpath("//input[contains(@id,'em')]"));

//Axes 3)following--

//current node                                         //target node
//tagname[@attributeName='AttributeValue']//following::tagname

//Tag <p>ke badd <form>;If we know Xpath for <p> properly then it is easy to locate its next element
driver.findElement(By.xpath("//p[@class='login-box-msg']//following::form"));  
driver.findElement(By.xpath("//p[text()='Sign in to start your session']//following::form"));
driver.findElement(By.xpath("//tr[2]/td[7]//following::span"));      //USer table Delete Button of row2(kiran)
driver.findElement(By.xpath("//tr[3]/td[3]//following::span[4]")); //Operator table Row3 ki
//Axes 4)preceding---

//current node                                         //target node
//tagname[@attributeName='AttributeValue']//preceding::tagname

//Tag <p>Sign in to start your session'</p> ke pehle h4 tag hai ,we try to locate h4
driver.findElement(By.xpath("//p[@class='login-box-msg']//preceding::h4"));
driver.findElement(By.xpath("//p[text()='Sign in to start your session']//preceding::form"));
}
}
