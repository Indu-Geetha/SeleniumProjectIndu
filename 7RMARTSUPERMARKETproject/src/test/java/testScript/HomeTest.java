package testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class HomeTest extends Base {

	public HomePage home;

	@Test
	public void verifyLogOut() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "HomeTestData");
		String password = ExcelUtility.getStringData(1, 1, "HomeTestData");
		
		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username, password);
		home = login.clickSignInButton();
		home.clickLogout();
		
		//Assertion 
		boolean isSignInTextDisplayed = login.isSignintostartyoursessionDisplayed();
		Assert.assertTrue(isSignInTextDisplayed,Constant.ERROR_MSG_LogOut);
		
		

	}

}