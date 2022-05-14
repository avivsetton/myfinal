package tests;


import static org.testng.Assert.assertEquals;

import java.io.PrintStream;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.loginPage;



public class LoginTest extends BaseTest {
	WebDriver driver;
	private PrintStream verificationErrors;

	@Test
	public void loginfalid() {

		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "111");
		try {
		    assertEquals(lp.getText(null), "Username and password do not match any user in this service");

		    //If the message is displayed

		    System.out.println("PASS");

		} catch (Exception e) {

		    //If the message is not displayed

		    System.out.println("FAIL");
		    verificationErrors = null;
		    verificationErrors.append(e.toString());
		}

		   
	}

	@Test
	public void loginSucceed() {
		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");
		try {
		    assertEquals(lp.getText(null), "Username and password do not match any user in this service");

		    //If the message is displayed

		    System.out.println("PASS");

		} catch (Exception e) {

		    //If the message is not displayed

		    System.out.println("FAIL");

		    verificationErrors = null;
			verificationErrors.append(e.toString());

		}

	}

}
