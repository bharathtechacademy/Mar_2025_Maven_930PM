package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.selenium.dev/");
		
		System.out.println(driver.getTitle());
		
		long number = 2358743758L;
		
		driver.close();
	}

}
