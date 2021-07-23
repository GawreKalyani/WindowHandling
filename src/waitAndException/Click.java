package waitAndException;

public class Click {
	/*Below are some methods that will be useful to click a button/Image.

	WebDriver driver = new ChromeDriver();
	    driver.get("http://newtours.demoaut.com");
	    WebElement signOnImage = driver.findElement(By.xpath("//input[@type='image'][@name='login']"));

	// direct method from the API which is recommended always
	    signOnImage.click(); 
	1 Using Return Key

	    //signOnImage.sendKeys(Keys.RETURN); 
	2 Using JavascriptExecutor

	2.1 
	    JavascriptExecutor js = (JavascriptExecutor)driver; 
	    js.executeScript("arguments[0].click();", signOnImage);

	2.2         
	    JavascriptExecutor js = (JavascriptExecutor) driver; 
	    js.executeScript("document.getElementsByName('login')[0].click()");
	3 Using Actions class

	3.1
	    Actions actions = new Actions(driver);  
	    actions.click(signOnImage).perform();
	3.2
	    Actions actions = new Actions(driver);
	    actions.moveToElement(signOnImage).click().perform();
	*/
}
