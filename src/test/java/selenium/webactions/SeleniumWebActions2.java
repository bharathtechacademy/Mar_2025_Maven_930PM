package selenium.webactions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumWebActions2 {

	static WebDriver driver;

	public static void main(String[] args) {
//		1. Launch browser window
		driver = new ChromeDriver();

//		2. Maximize the browser window
		driver.manage().window().maximize();

//		3. Delete all the cookies
		driver.manage().deleteAllCookies();

//		4. Enter URL and Launch the application (https://demoqa.com/automation-practice-form)
		driver.get("https://demoqa.com/automation-practice-form");

//		5. Wait for Page-load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//		6. Enter First name and Last name
		WebElement FirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement LastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		
		FirstName.sendKeys("Bharath");
		LastName.sendKeys("Reddy");

//		7. Enter Email
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		email.sendKeys("BharathTechAcademy@gmail.com");

//		8. Select Gender (Male)
		selectGender("Male");

//		9. Enter mobile number
		WebElement mobile = driver.findElement(By.xpath("//input[@id='userNumber']"));
		mobile.sendKeys("9876543210");

//		10.Select DOB (1-Feb-1991)
		selectDOB("1", "February", "1991");

//		11.Search and Select Computer Science
		selectSubject("Computer Science");		

//		12.Select Hobbies as Sports and Reading
		String hobbies[] = {"Sports", "Reading"};
		selectHobbies(hobbies);

//		13.Upload photo
		String filePath = System.getProperty("user.dir") + "\\Files\\Photo.png";
		WebElement uploadButton = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		uploadButton.sendKeys(filePath);

//		15.Submit Details
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitButton);

//		16. Close browser window
		driver.quit();
	}
	
	public static void selectGender(String option) {
		WebElement gender = driver.findElement(By.xpath("//label[text()='"+option+"']"));
		gender.click();
	}
	
	public static void selectDOB(String date, String month, String year) {
		WebElement dobInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		dobInput.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='react-datepicker__month-select']")));
		
		// Select month from the date picker
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));		
		Select m = new Select(monthDropdown);
		m.selectByVisibleText(month);
		
		// Select year from the date picker
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select y = new Select(yearDropdown);
		y.selectByVisibleText(year);
		
		// Select date from the date picker
		WebElement dateElement = driver.findElement(By.xpath("//div[contains(@aria-label,'"+month+"') and text()='"+date+"']"));
		dateElement.click();
		
		}
	
	public static void selectSubject(String subject) {
		WebElement subjectInput = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		
		//Scroll till the subject input field is visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", subjectInput);
		
		// Enter the subject in the input field
		Actions action = new Actions(driver);
		action.sendKeys(subjectInput, subject).perform();
		
		// Wait for the subject options to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+subject+"' and contains(@class,'option')]")));
		
		//Click on the subject option
		WebElement subjectOption = driver.findElement(By.xpath("//div[text()='"+subject+"' and contains(@class,'option')]"));
		subjectOption.click();		
		
	}
	
	public static void selectHobbies(String[] hobbies) {
		for (String hobby : hobbies) {
			WebElement hobbyCheckbox = driver.findElement(By.xpath("//label[text()='" + hobby + "']"));
			if (!hobbyCheckbox.isSelected()) {
				hobbyCheckbox.click();
			}
		}
	}

}
