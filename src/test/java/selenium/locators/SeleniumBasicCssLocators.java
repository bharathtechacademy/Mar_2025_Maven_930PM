package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicCssLocators {
	
//	Syntax 1 : tagName#id
	
//	Syntax 2 : tagName.className
	
//	Syntax 3 : tagName[Attribute='attribute-value’]

	public static void main(String[] args) {
		
//		1. Launch the Browser window (Browser = Chrome)   
		WebDriver driver = new ChromeDriver();
		
//		2. Maximize the browser window   
		driver.manage().window().maximize();
		
//		3. Enter URL and Launch the Application (https://www.google.co.in/)
		driver.get("https://www.google.co.in/");
		
//		4. Find the search box using css locator -syntax 1
		driver.findElement(By.cssSelector("textarea#APjFqb"));
		
//		5. Find the search box using css locator -syntax 2
		driver.findElement(By.name("textarea.gLFyf"));
		
//		6. Find the search box using css locator -syntax 3
		driver.findElement(By.className("textarea[title='Search']"));
		

	}

}
