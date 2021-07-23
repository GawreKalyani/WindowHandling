package actionsClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginRobot {
public static void main(String[] args) throws AWTException {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyPress(KeyEvent.VK_TAB);  	//Email textbox pe cursor
	r.keyPress(KeyEvent.VK_K);
	r.keyPress(KeyEvent.VK_I);
	r.keyPress(KeyEvent.VK_R);
	r.keyPress(KeyEvent.VK_A);
	r.keyPress(KeyEvent.VK_N);
	r.keyPress(KeyEvent.VK_SHIFT);   //Shift+2=@
	r.keyPress(KeyEvent.VK_2);
	r.keyRelease(KeyEvent.VK_SHIFT);
	r.keyRelease(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_G);
	r.keyPress(KeyEvent.VK_M);
	r.keyPress(KeyEvent.VK_A);
	r.keyPress(KeyEvent.VK_I);
	r.keyPress(KeyEvent.VK_L);
	r.keyPress(KeyEvent.VK_DECIMAL);  //DEcimal= .
	r.keyPress(KeyEvent.VK_C);
	r.keyPress(KeyEvent.VK_O);
	r.keyPress(KeyEvent.VK_M);
	r.keyPress(KeyEvent.VK_TAB);      //cursor password textbox pe
	r.keyPress(KeyEvent.VK_1);
	r.keyPress(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_3);
	r.keyPress(KeyEvent.VK_4);
	r.keyPress(KeyEvent.VK_5);
	r.keyPress(KeyEvent.VK_6);
	r.keyPress(KeyEvent.VK_TAB);     //log in button get selected
	r.keyPress(KeyEvent.VK_ENTER);   //log in button gets click
}
}
