package selenium.basics;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertions {

	public static void main(String[] args) {
		// 2 types of Assertions
		
		// Hard Assertion ==> Fail the program immediately when there is a error
		// Soft Assertions ==> Fail the program at the end by collecting all errors
		
		// Hard Assertion
		Assert.assertEquals("Google", "Google");
		Assert.assertNotEquals("Google", "Yahoo");
		Assert.assertTrue(2 < 3);
		Assert.assertFalse(2 > 3);
		Assert.assertNull(null);
		Assert.assertNotNull(1234);
//		Assert.fail("Fail the Program");

		// Soft Assertion
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Google", "Yahoo");
		softAssert.assertNotEquals("Google", "Google");
		softAssert.assertTrue(2 > 3);
		softAssert.assertFalse(2 < 3);
		softAssert.assertNull(1234);
		softAssert.assertNotNull(null);
		softAssert.fail("Fail the Program");
//		softAssert.assertAll();
		
		System.out.println("Execution Completed");

	}

}
