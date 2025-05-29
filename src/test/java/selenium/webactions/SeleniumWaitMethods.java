package selenium.webactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitMethods {
	
	// Implicit Wait  ==> Set a default wait time for all elements to wait for maximum of specified time before throwing an exception if the element is not found.
	// Explicit Wait  ==> Wait for a specific condition to occur before proceeding further in the code. This is more flexible and can be applied to specific elements.
	// Fluent Wait ==> Wait for a specific condition to occur before proceeding further in the code, but it allows for polling at regular intervals until the condition is met or the timeout is reached.

	public static void main(String[] args) {
		
//		1. Launch browser window
		WebDriver driver = new ChromeDriver();
		
//		2. Maximize the browser window
		driver.manage().window().maximize();
		
//		3. Delete all the cookies
		driver.manage().deleteAllCookies();
		
//		4. Enter URL and Launch the application (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
// 		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
//		Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0));
		
//		Fluent Wait
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
		fluentWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0));

	}

}
