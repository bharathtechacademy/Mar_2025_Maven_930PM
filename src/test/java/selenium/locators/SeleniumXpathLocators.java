package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumXpathLocators {
	
	//Xpath ==> XML Path
	
	// Absolute Xpath ==> Full Xpath from the root element to the target element ==> Starts with a single slash (/) ==> /html/body/div[1]/div[2]/div/svg
	// Relative Xpath ==> Partial Xpath from the target element to the root element ==> Starts with a double slash (//) ==> //div[@class='example']/span[1]
	
	/********************Basic Xpath Syntaxs (Level 1) **********************/	
	// Syntax 1 : //tagName[@attribute='attribute-value']
	// Syntax 2 : //tagName[text()='text-value']
	
	/********************Level 2 - with contains & starts-with**********************/	
	// Syntax 3 : //tagName[contains(@attribute,'partial-attribute-value')]
	// Syntax 4 : //tagName[contains(text(),'partial-text-value')]
	
	// Syntax 5 : //tagName[starts-with(@attribute,'partial-attribute-value-starts-with')]
	// Syntax 6 : //tagName[starts-with(text(),'partial-text-value-starts-with')]
	
	/********************Level 3 - combining multiple attributes & text values using 'and' **********************/
	// Syntax 7 : //tagName[@attribute1='attribute-value1' and @attribute2='attribute-value2' and text()='text-value']
	
	/********************Level 4 - advanced Xpath by using relationships **********************/
	// Syntax 8 : referenceElementXpath/relationship::targetElementXapath
	
	//child
	//parent
	//preceding
	//following
	//ancestor
	//preceding-sibling
	//following-sibling
	//
	
	
	//ancestor ==> //ul[@class='leftmenu']
	//parent ==> //li
	//target ==> //a[text()='Services']
	
	//ul[@class='leftmenu']/child::li/child::a[text()='Services']
	//ul[@class='leftmenu']//a[text()='Services']
	
	// target --> sibling --> parent --> ancestor --> ancestor's parent

	public static void main(String[] args) {
		
//		1. Launch the Browser window (Browser = Chrome)   
		WebDriver driver = new ChromeDriver();
		
//		2. Maximize the browser window   
		driver.manage().window().maximize();
		
//		3. Enter URL and Launch the Application (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
//		4. Find the 'logo' image using xapth locator -syntax 1
		driver.findElement(By.xpath("//img[@class='logo']"));
		
//		5. Find the 'caption' text using xapth locator -syntax 2
		driver.findElement(By.xpath("//p[text()='Experience the difference']"));
		
//		6. Find the 'logo' image using xapth locator -syntax 3
		driver.findElement(By.xpath("//img[contains(@src,'logo')]"));
		
//		7. Find the 'caption' text using xapth locator -syntax 4
		driver.findElement(By.xpath("//p[contains(text(),'the difference')]"));		
		
//		8. Find the 'logo' image using xapth locator -syntax 5
		driver.findElement(By.xpath("//img[starts-with(@src,'images/logo')]"));
		
//		9. Find the 'caption' text using xapth locator -syntax 6
		driver.findElement(By.xpath("//p[contains(text(),'Experience')]"));
		
//		10. Find the 'caption' text using xapth locator -syntax 7
		driver.findElement(By.xpath("//p[@class='caption' and text()='Experience the difference']"));
		
//		11. Find the 'services' link using xapth locator -syntax 8
		driver.findElement(By.xpath("//ul[@class='leftmenu']//a[text()='Services']"));

	}

}
