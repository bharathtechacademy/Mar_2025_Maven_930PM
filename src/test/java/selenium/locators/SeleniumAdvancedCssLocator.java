package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAdvancedCssLocator {
	
	// ancestor's parent > ancestor > parent > target
	
	
	//ancestor ==> ul[class='leftmenu']
	//parent ==> li:nth-child(3)
	//target ==> a[href='services.htm']
			
	//		ul[class='leftmenu'] > li > a[href='services.htm']

	public static void main(String[] args) {
	
//		1. Launch the Browser window (Browser = Chrome)   
		WebDriver driver = new ChromeDriver();
		
//		2. Maximize the browser window   
		driver.manage().window().maximize();
		
//		3. Enter URL and Launch the Application (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
//		4. Find the 'Services' Link using css locator -syntax 4
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li > a[href='services.htm']"));
	}

}
