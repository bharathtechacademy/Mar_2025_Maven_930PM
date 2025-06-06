package testng.concepts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class WebCommons {
	
	@BeforeSuite
	public void startReporting() {
		System.out.println("Reporting process started.....");
	}
	
	@AfterSuite
	public void stopReporting() {
		System.out.println("Reporting process stopped and Report generated.....");
	}
	
	@BeforeMethod
	@Parameters({"BROWSER", "URL"})
	public void launchBrowserAndApplication(String browser, String url) {
		System.out.println(browser+" is launched...");
		System.out.println(url+" is launched...");
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Browser is closed....");
	}
	
	@DataProvider(name = "loginData")
	public String[][] testData() {
		String[][] data = { { "user1", "pass1" }, { "user2", "pass2" }, { "user3", "pass3" } };
		return data;
	}

}
