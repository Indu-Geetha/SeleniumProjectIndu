package testScript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {

	public LoginPage login;
	public HomePage home;

	@Test(dataProvider = "loginData", priority = 1)
	public void verifyLoginWithValidCredentials(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username, password);
		home = login.clickSignInButton();

		// Assertion............
		boolean isHomePageDisplayed = login.isDashboardTextDisplayed();
		Assert.assertTrue(isHomePageDisplayed, Constant.ERROR_MSG_LoginWithValidCredentials);

	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		Object data[][] = { { "admin", "admin" } };
		return data;

	}

	@Test(priority = 2)
	@Parameters({ "username", "password" })
	public void verifyLoginWithValidUsernameInvalidPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username, password);
		home = login.clickSignInButton();

		// Assertion............
		boolean alertDisplayed = login.isAlertMessageDisplayed();
		Assert.assertTrue(alertDisplayed, Constant.ERROR_MSG_LoginWithValidUsernameInvalidPassword);

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidUsenameValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username, password);

		home = login.clickSignInButton();

		// Assertion............
		boolean alertDisplayed = login.isAlertMessageDisplayed();
		Assert.assertTrue(alertDisplayed, Constant.ERROR_MSG_LoginWithInvalidUsenameValidPassword);

	}

	@Test(priority = 4)
	public void verifyLoginWithInvalidUsenameInValidPassword() throws IOException {

		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username, password);

		home = login.clickSignInButton();

		// Assertion............
		boolean alertDisplayed = login.isAlertMessageDisplayed();
		Assert.assertTrue(alertDisplayed,Constant.ERROR_MSG_LoginWithInvalidUsenameInValidPassword );
	}

}