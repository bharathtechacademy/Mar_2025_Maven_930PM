package selenium.webActionMethods;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumWebActions {

	public static void main(String[] args) throws IOException {

//		1. Launch the Browser window (Browser = Chrome) 
		WebDriver driver = new ChromeDriver();

//		2. Maximize the browser window  
		driver.manage().window().maximize();

//		3. Delete all browser cookies 
		driver.manage().deleteAllCookies();

//		4. Enter URL and Launch the Application (https://www.google.co.in/)  
		driver.get("https://www.google.co.in/");
		
//		5. Locate the element
		WebElement element = driver.findElement(By.xpath("//element"));
		
		/********** Common WebElement Actions **********/
		
		// Check if the element is displayed on the page
		boolean isElementDisplayed = element.isDisplayed(); //true means element is displayed, false means not displayed
		
		// Check if the element is enabled on the page
		boolean isElementEnabled = element.isEnabled(); //true means element is enabled, false means not enabled
		
		// Check if the element is selected
		boolean isElementSelected = element.isSelected(); //true means element is selected, false means not selected
		
        /************* Regular Element Specific Actions *************/

        /********** Button Element **********/
		WebElement button = driver.findElement(By.xpath("//button"));
		
		// Get the label of the button
		String buttonLabel1 = button.getText(); //if the button has text value inside it
		String buttonLabel2 = button.getAttribute("value"); //if the button has value attribute
		
		// Click on the button
		button.click();
		
		// double click
		Actions action = new Actions(driver);
		action.doubleClick(button).perform();
		
		// right click
		action.contextClick(button).perform();
		
		// move the mouse pointer towards button
		action.moveToElement(button).perform();
		
		// drag and drop 
		action.dragAndDrop(button, button).perform();
		
		// Scroll and Click on the hidden element when element is at the bottom of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", button); // Scroll to the button element
		
		button.click(); // Click on the button after scrolling
		
		// Click on the hidden element
		js.executeScript("arguments[0].click();", button);
		
		/********** Text Box Element **********/
		
		WebElement textbox = driver.findElement(By.xpath("//input"));
		
		// Clear the textbox
		textbox.clear();
		
		// Enter text into the textbox
		textbox.sendKeys("Hello World");
		
		// Verify the placeholder of the textbox
		String placeholderText = textbox.getAttribute("placeholder");
		
		// Enter text using Actions class to type chars 
		action.sendKeys(textbox,"Hello World").perform();
		action.sendKeys(textbox,"Hello World"+Keys.ENTER).perform();
		
		// Enter text into the textbox which is disabled and hidden
		js.executeScript("arguments[0].value='Text to Enter'", button);
		
		/********** Dropdown Element **********/
		
		WebElement dropdown = driver.findElement(By.xpath("//select"));
		
		// Get all options available in the dropdown
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText()); // Print each option text
		}
		
		// Select options from a dropdown
		select.selectByVisibleText("Option 1"); // Select by visible text
		select.selectByValue("option2"); // Select by value attribute
		select.selectByIndex(1); // Select by index (0-based)
		
		// Verify the selected option
		String selectedOption = select.getFirstSelectedOption().getText(); // Get the first selected option text
		
		// Verify whether dropdown is multi-select dropdown
		boolean isMultiSelect = select.isMultiple(); // true if multi-select, false if single-select
		
		// Select and de-select options
		select.selectByVisibleText("Option 1"); // Select by visible text
		select.selectByValue("option2"); // Select by value attribute
		select.selectByIndex(1); // Select by index (0-based)
		// De-select options from a multi-select dropdown
		select.deselectByVisibleText("Option 1"); // De-select by visible text
		select.deselectByValue("option2"); // De-select by value attribute
		select.deselectByIndex(1); // De-select by index (0-based)
		
		/********** Checkbox Element **********/
		
		// select the checkbox if it is not selected already
		WebElement checkbox = driver.findElement(By.xpath("//input"));
		if (!checkbox.isSelected()) {
			checkbox.click(); // Click to select the checkbox
		}
		
		/********** Radio Button Element **********/
		
		// Select the radio button
		WebElement radioButton = driver.findElement(By.xpath("//input"));
		radioButton.click(); // Click to select the radio button
		
		/********** Text Element / Label  **********/
		//get the text values from web element
		WebElement label = driver.findElement(By.xpath("//input"));
		String label1 = button.getText(); //if the label has text value inside it
		String label2 = button.getAttribute("value"); //if the label has value attribute
		
		/********** Hyperlink Element **********/
		WebElement hyperLink = driver.findElement(By.xpath("//a"));
		
		 // Verify the URL in the hyperlink using href value
		String hyperlinkUrl = hyperLink.getAttribute("href"); // Get the URL from the href attribute
		
		// Verify the URL in the hyperlink by clicking on the link and check the updated url 
		hyperLink.click(); // Click on the hyperlink
		String currentUrl = driver.getCurrentUrl(); // Get the current URL after clicking the hyperlink
		
		/********** Image Element **********/
		WebElement image = driver.findElement(By.xpath("//img"));
		
		// Verify if the image element is displayed		
		boolean isImageDisplayed = image.isDisplayed(); // true if the image is displayed, false if not
		
		// Verify image is valid		
		String imageUrl = image.getAttribute("src"); // Get the URL of the image from the src attribute
		
		// Verify the image dimensions
		int imageWidth = image.getSize().getWidth(); // Get the width of the image
		int imageHeight = image.getSize().getHeight(); // Get the height of the image
		
		// Get the position of the image		
		int imageX = image.getLocation().getX(); // Get the X coordinate of the image
		int imageY = image.getLocation().getY(); // Get the Y coordinate of the image
		
		// verify a specific pixel color
		//String pixelColor = js.executeScript("return window.getComputedStyle(arguments[0]).backgroundColor;", image).toString();
		int colorCode = ImageIO.read(new File(imageUrl)).getRGB(0, 0); // Get the color code of a specific pixel (0,0) in the image
		
	}

}
