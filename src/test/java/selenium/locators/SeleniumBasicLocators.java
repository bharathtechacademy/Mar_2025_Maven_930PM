package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicLocators {
	
	// WebElement element = driver.findElement(By.locatorType("locator-value"));
	// By Loctor = By.locatorType("locator-value");
	
//	1. id  ==> id attribute value of element
//	2. name ==> name attribute value of element
//	3. className ==> class attribute value of element
//	4. tagName ==> Html tag value of element
//	5. linkText ==> text value of hyperlink elements
//	6. partialLinkText ==> partial text value of hyperlink elements

	public static void main(String[] args) {
		
//		1. Launch the Browser window (Browser = Chrome)   
		WebDriver driver = new ChromeDriver();
		
//		2. Maximize the browser window   
		driver.manage().window().maximize();
		
//		3. Enter URL and Launch the Application (https://www.google.co.in/)
		driver.get("https://www.google.co.in/");
		
//		4. Find the search box using id locator
		driver.findElement(By.id("APjFqb"));
		
//		5. Find the search box using name locator
		driver.findElement(By.name("q"));
		
//		6. Find the search box using className locator
		driver.findElement(By.className("gLFyf"));
		
//		7. Find the search box using tagName locator
		driver.findElement(By.tagName("textarea"));
		
//		8. Find the 'How Search Work' link using linkText locator
		driver.findElement(By.linkText(" How Search works "));
		
//		9. Find the 'How Search Work' link using partialLinkText locator
		driver.findElement(By.partialLinkText("How Search"));
		

	}

}
