package testng.concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppCommons extends WebCommons{
	
	@Test(priority = 2, groups= {"Regression"},retryAnalyzer=RetryTest.class)
	public void TestCase1() {
		Assert.fail("Test Case 1 - Home Page Validations Failed..."); // Simulating a failure for demonstration
		System.out.println("Test Case 1 - Home Page Validations Executed Successfully...");
	}
	
	@Test(priority = 3, groups= {"Smoke"}, enabled=true)
	public void TestCase2() {
		System.out.println("Test Case 2 - Add Product to Cart Feature Validations Executed Successfully...");
	}	

	@Test(dataProvider = "loginData",priority = 1,dependsOnMethods = {"TestCase1"},groups= {"Regression","Smoke","Sanity"}) //
	public void TestCase3(String username, String password) {
		System.out.println("Test Case 3 - Login Validations Executed Successfully with..."+username+" ,"+password);
	}

}
