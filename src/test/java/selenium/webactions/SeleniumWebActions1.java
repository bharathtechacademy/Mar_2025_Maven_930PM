package selenium.webactions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumWebActions1 {
	
	static WebDriver driver;

	public static void main(String[] args) {
//		1. Launch browser window
		driver = new ChromeDriver();
		
//		2. Maximize the browser window
		driver.manage().window().maximize();
		
//		3. Delete all the cookies
		driver.manage().deleteAllCookies();
		
//		4. Enter URL and Launch the application (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
//		5. Verify application title
		String expectedTitle = "ParaBank | Welcome | Online Banking";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
//		6. Verify application logo
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
		Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on the page.");
		
//		7. Verify application caption
		
		WebElement caption = driver.findElement(By.xpath("//p[@class='caption']"));
		String expectedCaption = "Experience the difference";
		String actualCaption = caption.getText();
		Assert.assertEquals(actualCaption, expectedCaption, "Caption does not match the expected text.");
		
//		8. Enter Invalid credentials in Username and Password textboxes
		
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		
		usernameField.clear();
		passwordField.clear();
		// Entering invalid credentials
		usernameField.sendKeys("invalidUser");
		passwordField.sendKeys("invalidPass");		
		
//		9. Click on Login Button		
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
		loginButton.click();
				
//		10. Verify error message is displayed (The username and password could not be verified.)		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0)); 
		
//		WebElement errorMessage = driver.findElement(By.xpath("//p[@class='error']"));
//		String expectedErrorMessage = "The username and password could not be verified.";
//		String actualErrorMessage = errorMessage.getText();
//		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match the expected text.");
		
//		11. Click on Adminpage link
		WebElement adminPageLink = driver.findElement(By.xpath("//a[contains(text(),'Admin Page')]"));		
		adminPageLink.click();
		
//		12. Wait for admin page		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h1[contains(text(),'Administration')]"), 0));
		
//		13. Select Data access mode as ' SOAP'
		selectDataAccessMode("soap");
		
//		14. Scrolldown till Loan provider
		WebElement loanProvider = driver.findElement(By.xpath("//select[@id='loanProvider']"));			
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", loanProvider);
		
//		15. Select Loanprovider as 'Web Service'
		Select s = new Select(loanProvider);
		s.selectByVisibleText("Web Service");
		
//		16. Click on Submit button
		WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));			
		submitButton.click();
		
//		17.wait for Successful submission message
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//b[text()='Settings saved successfully.']"), 0));
		
//		18.Click on Services Link
		WebElement servicesLink = driver.findElement(By.xpath("//ul[@class='leftmenu']//a[text()='Services']"));			
		servicesLink.click();
		
//		19.Wait for Services page
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[text()='Bookstore services:']"), 0));
		
//		20.Scrolldown till Bookstore services
		WebElement bookstoreServices =driver.findElement(By.xpath("//span[text()='Bookstore services:']"));
		js.executeScript("arguments[0].scrollIntoView()", bookstoreServices);

//		21.Get total rows, columns in the bookstore service table
		List<WebElement> rows = driver.findElements(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr"));
		int totalRows = rows.size();
		
		List<WebElement> columns = driver.findElements(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr[1]//td"));
		int totalColumns = columns.size();
		
//		22.Get Column headers of book store services table
		for(WebElement header : columns) {
			System.out.println(header.getText());
		}
		
//		23.Get all the data from book store service table
		for(int r=1;r<=totalRows; r++) {
			for(int c=1; c<=totalColumns; c++) {
				WebElement cell = driver.findElement(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr["+r+"]//td["+c+"]"));
				System.out.println("Row "+r+" Column "+c+" Value is :"+cell.getText());
			}
		}
		
//		24.Close browser window
		driver.quit();
	}

	public static void selectDataAccessMode(String option) {
		WebElement dataAccessMode = driver.findElement(By.xpath("//input[@value='"+option+"']"));
		dataAccessMode.click();
	}
}
