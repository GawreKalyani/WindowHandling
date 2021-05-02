package com.javabykiran;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase1 {

	WebDriver driver;

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();// to maximize the browser
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void checkLogo() {
		WebElement image = driver.findElement(By.tagName("img"));
		boolean actual = image.isDisplayed();
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void checkUrl() {

		String act = driver.getCurrentUrl();
		String exp = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html";

		Assert.assertEquals(act, exp);
	}

	@Test(priority = 3)
	public void verifyTitle() {
		String title = driver.getTitle();
		String exptitle = "JavaByKiran | Log in";

		Assert.assertEquals(title, exptitle);
	}

	@Test(priority = 4)
	public void checkHeadingJavabykiran() {
		// head2 (Java By Kiran)
		String actualvar = driver.findElement(By.xpath("//b[contains(text(),'Kiran')]")).getText();
		String expectedvar = "Java By Kiran";

		Assert.assertEquals(actualvar, expectedvar);
	}

	@Test(priority = 5)
	public void verifyCoursesHeading() {
		// head1 (Java Python Selenium)
		String actcourse = driver.findElement(By.xpath("//h4[contains(text(),'JAVA')]")).getText();
		String expcouse = "JAVA | SELENIUM | PYTHON";

		Assert.assertEquals(actcourse, expcouse);
	}

	@Test(priority = 6)
	public void verifySignInHeading() {
		// Login Page :Heading Sign in to start your session(index.html)
		String actualheading = driver.findElement(By.xpath("//p[contains(text(),'Sign')]")).getText();
		String expheading = "Sign in to start your session";

		Assert.assertEquals(actualheading, expheading);
	}

	@Test(priority = 7)
	public void checkLoginSuccessfullyDone() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String actualdata = driver.getTitle();
		
		String expectedata = "JavaByKiran | Dashboard";

		Assert.assertEquals(actualdata, expectedata);
	}

	@Test(priority = 8)
	public void verifyBlankEmailErrorMsg() {
		if (!driver.getTitle().contains("Log in"))
			driver.findElement(By.linkText("LOGOUT")).click();
		// Login without data entering
		driver.findElement(By.id("email")).sendKeys("");

		driver.findElement(By.xpath("//button")).click();
		String errorMessage = driver.findElement(By.id("email_error")).getText();

		Assert.assertEquals(errorMessage, "Please enter email.");
	}

	@Test(priority = 9)
	public void verifyBlankPasswordErrorMsg() {
		String errorMessage1 = driver.findElement(By.id("password_error")).getText();

		Assert.assertEquals(errorMessage1, "Please enter password.");
	}

	@Test(priority = 10)
	public void verifyInvalidLoginEntryEmailErrorMessage() {
		driver.findElement(By.id("email")).sendKeys("kas@gmail.com");
		driver.findElement(By.id("password")).sendKeys("lll");
		driver.findElement(By.xpath("//button")).click();
		String errorMessage1 = driver.findElement(By.id("email_error")).getText();

		Assert.assertEquals(errorMessage1, "Please enter email as kiran@gmail.com");
	}

	@Test(priority = 11)
	public void verifyInvalidLoginEntryPasswordErrorMessage() {
		String errorMessage1 = driver.findElement(By.id("password_error")).getText();

		Assert.assertEquals(errorMessage1, "Please enter password 123456");
	}

	@Test(priority = 12)
	public void checkRegistration() {
		driver.findElement(By.partialLinkText("Register")).click();

		String actualdata = driver.getTitle();
		
		String expectedata = "JavaByKiran | Registration Page";

		Assert.assertEquals(actualdata, expectedata);
	}

	@Test(priority = 13)
	public void checkRegisterPgHeading() {
		String actual = driver.findElement(By.xpath("//b[contains(text(),'Kiran')]")).getText();
		String expected = "Java By Kiran";

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 14)
	public void varifyRegisterHeading2() {

		String actual = driver.findElement(By.xpath("//p[contains(text(),'Register')]")).getText();
		String expected = "Register a new membership";

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 15)
	public void checkRegisterPgNameError() {
		driver.findElement(By.id("name")).sendKeys("");
		driver.findElement(By.id("mobile")).sendKeys("");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button")).click();
		String error = driver.findElement(By.id("name_error")).getText();
		String exp1 = "Please enter Name.";

		Assert.assertEquals(error, exp1);
	}

	@Test(priority = 16)
	public void checkRegisterPgMobileError() {

		String error = driver.findElement(By.id("mobile_error")).getText();
		String exp1 = "Please enter Mobile.";

		Assert.assertEquals(error, exp1);
	}

	@Test(priority = 17)
	public void checkRegisterPgEmailError() {
		
		String error = driver.findElement(By.id("email_error")).getText();
		String exp1 = "Please enter Email.";

		Assert.assertEquals(error, exp1);
	}

	@Test(priority = 18)
	public void checkRegisterPgPasswordError() {

		String error = driver.findElement(By.id("password_error")).getText();
		String exp1 = "Please enter Password.";

		Assert.assertEquals(error, exp1);
	}
	@Test(priority = 19)
	public void checkRegPgUrl() {

		String act = driver.getCurrentUrl();
		String exp = ("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html");
		driver.close();
		Assert.assertEquals(act, exp);
	}
	@Test(priority = 20)
	public void verifyAlreadyRegisteredMember()
	{
		driver.findElement(By.partialLinkText("I")).click();
		String actual = driver.getTitle();
		System.out.println(""+actual);
		String expected = "JavaByKiran | Log in";

		Assert.assertEquals(actual, expected);
	}
	

	

}
