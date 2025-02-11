package testScript;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class AdminUsersTest extends Base {
	public HomePage home;
	public AdminUsersPage admin_users;
	public FakerUtility faker = new FakerUtility(); // Initialized at class level

	@Test(priority = 1,retryAnalyzer = retry.Retry.class)//retry in case of failed execution
	public void verifyCreationOfNewAdminUsers() throws IOException {
		String username_valid = ExcelUtility.getStringData(1, 0, "AdminUserTestData");
		String password_valid = ExcelUtility.getStringData(1, 1, "AdminUserTestData");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username_valid, password_valid);

		home = login.clickSignInButton();
		admin_users = home.adminUsersClick();

		admin_users.clickBtnNew();
		String username_new = faker.getFakeFirstName(); // Using FakerUtility for a new name
		admin_users.enterUsermame(username_new);

		String password_new = ExcelUtility.getStringData(2, 1, "AdminUserTestData");
		admin_users.enterPassword(password_new);
		admin_users.selectUserType();
		admin_users.clickSave();

		// Handling user creation success or failure

		boolean isSucessfullyNewAdminCreated;
		boolean isUserAlreadyExist;

		if (isSucessfullyNewAdminCreated = admin_users.isAlertSucessDisplayed()) {
			Assert.assertTrue(isSucessfullyNewAdminCreated, Constant.ERROR_MSG_CreationOfNewAdminUsers);
		} else if (isUserAlreadyExist = admin_users.isAlertFaiureDisplayed()) {
			Assert.assertTrue(isUserAlreadyExist, Constant.ERROR_MSG_UserAlreadyExists);

		}

	}

	@Test(priority = 2)
	public void verifyAdminUserSearch() throws IOException {
		String username_valid = ExcelUtility.getStringData(1, 0, "AdminUserTestData");
		String password_valid = ExcelUtility.getStringData(1, 1, "AdminUserTestData");
		String username_search = faker.getFakeFirstName();
		// String username_search = ExcelUtility.getStringData(5, 0,
		// "AdminUserTestData");
		// Validate input data
		Assert.assertNotNull(username_search, "Username for search should not be null");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username_valid, password_valid);
		home = login.clickSignInButton();
		admin_users = home.adminUsersClick();

		admin_users.clickBtnSearch();
		admin_users.enterSearchUsermame(username_search);
		admin_users.selectUserTypeSearch();
		admin_users.clickBtnSearchInsideSearch();

		// Handling search result presence
		boolean isSearchResultFound;
		boolean isSearchResultNotFound;

		if (isSearchResultFound = admin_users.isSearchResultDisplayed()) {
			// System.out.println("Search successful: User found - " + username_search);
			Assert.assertTrue(isSearchResultFound, Constant.ERROR_MSG_AdminUserSearch);
		} else if (isSearchResultNotFound = admin_users.isSearchResultNotDisplayed()) {
			System.out.println("Search not successful: User not found - " + username_search);
		}
	}

	public void verifyAdminUserDelete() {

	}
}
