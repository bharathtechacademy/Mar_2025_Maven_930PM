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

import utilities.Reports;

public class SeleniumWebActions6 {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Reports.setupReport();
		
//		1. Launch browser window
		driver = new ChromeDriver();

//		2. Maximize the browser window
		driver.manage().window().maximize();

//		3. Delete all the cookies
		driver.manage().deleteAllCookies();
		
//		3.Launch the application (https://demoqa.com/alerts)
		driver.get("https://demoqa.com/alerts");
		       
//		4.Locate Alert buttons
		WebElement infoAlertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
		WebElement confirmAlertButtonButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		WebElement promptButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
		
		Reports.startReporting("Verify Application Logo");
		
//		take screenshot of logo
		WebElement logo = driver.findElement(By.xpath("//img[contains(@src,'Toolsqa.jpg')]"));
		Reports.logger.pass("Application Logo is displayed"); 
		Reports.logger.addScreenCaptureFromPath(elementScreenshot(logo, "application_logo"));	
		
		Reports.stopReporting();
			       
//		5.Launch Information alert
		infoAlertButton.click();
		
		Reports.startReporting("Verify Information Alert");

		
		//wait for alert to be present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Switch to alert and store alert in variable
		Alert simpleAlert = driver.switchTo().alert();
		Reports.logger.info("Confirmation Alert is displayed"); 
			       
//		6.Print Alert message
		String alertMessage = simpleAlert.getText();
		Reports.logger.warning("Alert message: " + alertMessage);
			       
//		7.Click on OK button
		simpleAlert.accept();
		Reports.logger.error("Confirmation Alert is closed"); 
		
		
		       
//		8.Launch confirmation alert
		confirmAlertButtonButton.click();
		
		//wait for alert to be present
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Switch to alert and store alert in variable
		Alert confirmAlert = driver.switchTo().alert();
		
//		9.Print Alert message
		String confirmAlertMessage = confirmAlert.getText();
		System.out.println("Confirm Alert message: " + confirmAlertMessage);
			       
//		10.Click on Cancel button
		confirmAlert.dismiss();
			       
//		11.Launch prompt alert with dialog box alert
		promptButton.click();
		
		//wait for alert to be present
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Switch to alert and store alert in variable
		Alert promptAlert = driver.switchTo().alert();

//		12.Print message
		String promptAlertMessage = promptAlert.getText();
		System.out.println("Prompt Alert message: " + promptAlertMessage);

//		13.Enter Text in Alert
		promptAlert.sendKeys("Hello, this is a test message!");
			       
//		14.Click on OK button
		promptAlert.accept();
		
//		take screenshot of window
		Reports.logger.addScreenCaptureFromPath(windowScreenshot(driver, "window_screenshot"));
		
//		15.Close the browser
		driver.quit();
		Reports.stopReporting();
		
	}
	
	public static String windowScreenshot(WebDriver driver, String fileName) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(screenshotPath));
		return screenshotPath;
	}

	public static String elementScreenshot(WebElement element, String fileName) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(screenshotPath));
		return screenshotPath;
	}

}
