package framework.concepts;

public class ApplicationTest {
	
	// Challenges
	
	//1. We cannot run each test case independently
	//2. Groping the test cases not possible
	//3. Executing specific test cases also not possible
	//4. Dependency tests also not possible
	//5. Test Prioritization is not possible
	//6. Test Data Parameterization
	//7. Inbuilt reporting not available
	//8. Monitoring test execution and act according to the test results
	//9. parallel testing

	public static void main(String[] args) {
		
		WebCommons commons = new WebCommons();
		AppCommons app = new AppCommons();
		
		commons.startReporting();
		
		commons.launchBrowserAndApplication("Chrome", "https://www.amazon.in");
		app.TestCase1();
		commons.closeBrowser();
		
		commons.launchBrowserAndApplication("Chrome", "https://www.amazon.in");
		app.TestCase2();
		commons.closeBrowser();
		
		commons.launchBrowserAndApplication("Chrome", "https://www.amazon.in");
		app.TestCase3("Bharath", "Bharath123");
		commons.closeBrowser();
		
		commons.launchBrowserAndApplication("Chrome", "https://www.amazon.in");
		app.TestCase3("Invalid User", "Invalid Pass");
		commons.closeBrowser();
		
		commons.stopReporting();

	}

}
