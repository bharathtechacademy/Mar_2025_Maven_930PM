package framework.concepts;

import org.testng.Assert;

public class AppCommons {
	
	public void TestCase1() {
		Assert.fail("Test Case 1 - Home Page Validations Failed..."); // Simulating a failure for demonstration
		System.out.println("Test Case 1 - Home Page Validations Executed Successfully...");
	}
	
	public void TestCase2() {
		System.out.println("Test Case 2 - Add Product to Cart Feature Validations Executed Successfully...");
	}	

	public void TestCase3(String username, String password) {
		System.out.println("Test Case 3 - Login Validations Executed Successfully with..."+username+" ,"+password);
	}

}
