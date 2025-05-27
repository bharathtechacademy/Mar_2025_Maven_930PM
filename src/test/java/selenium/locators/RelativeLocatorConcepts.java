package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorConcepts {
	
	// RelativeLocator.with(targetElementLocator).DIRECTION(referenceElementLocator);
	
	// above, below, toLeftOf, toRightOf, near

	public static void main(String[] args) {
		
//		1. Launch the Browser window (Browser = Chrome)   
		WebDriver driver = new ChromeDriver();
		
//		2. Maximize the browser window   
		driver.manage().window().maximize();
		
//		3. Enter URL and Launch the Application (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");		
		
//		4. Find the 'services' link using relative locator
		driver.findElement(RelativeLocator.with(By.linkText("Services")).below(By.tagName("About Us")));

	}

}
