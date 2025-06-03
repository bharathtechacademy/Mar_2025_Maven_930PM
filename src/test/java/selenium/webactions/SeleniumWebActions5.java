package selenium.webactions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumWebActions5 {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
//		1. Launch browser window
		driver = new ChromeDriver();

//		2. Maximize the browser window
		driver.manage().window().maximize();

//		3. Delete all the cookies
		driver.manage().deleteAllCookies();
		
//		3.Launch the application (https://demoqa.com/alerts)
		driver.get("https://demoqa.com/frames");
		
//		4.Locate mainwindow element
		WebElement mainWindowElement = driver.findElement(By.xpath("//h1[text()='Frames']"));
		
		//switch to the frame from the main window
		driver.switchTo().frame("frame1");
		
//		5. Locate the frame element
		WebElement frameElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		
//		6. Print the text  from frame element
		String frameText = frameElement.getText();
		System.out.println("Frame Text: " + frameText);
		
		// Switch back to the main window
		driver.switchTo().defaultContent();
		
//		7. Print the text from the main window element
		String mainWindowText = mainWindowElement.getText();
		System.out.println("Main Window Text: " + mainWindowText);
		
//		8.close the browser
		driver.quit();
		System.out.println("Browser closed successfully.");	       

		
	}
	
	

}
