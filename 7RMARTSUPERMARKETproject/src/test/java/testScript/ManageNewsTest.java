package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base {

	public HomePage home;
	public ManageNewsPage manage_news;

	@Test(priority = 1)
	public void verifyNewNewsCreation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "ManageNewsTestData");
		String password = ExcelUtility.getStringData(1, 1, "ManageNewsTestData");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username, password);
		home = login.clickSignInButton();

		String newsText = ExcelUtility.getStringData(1, 2, "ManageNewsTestData");
		manage_news = home.manageNewsClick();
		manage_news.newManageNewsClick().enterNews(newsText).newManageNewsSaveClick();

		// Assertion
		boolean isSuccessNewsCreationAlert = manage_news.isSucessAlertDisplayed();
		Assert.assertTrue(isSuccessNewsCreationAlert, Constant.ERROR_MSG_NewNewsCreation);

	}

	@Test(priority = 2)
	public void verifyCreatedNewsSearch() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "ManageNewsTestData");
		String password = ExcelUtility.getStringData(1, 1, "ManageNewsTestData");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username, password);
		home = login.clickSignInButton();
		manage_news = home.manageNewsClick();
		String newsTextToSearch = ExcelUtility.getStringData(1, 3, "ManageNewsTestData");
		manage_news.searchCreatedNewsClick().enterNewstoSearch(newsTextToSearch).searchNewsSearchBtnClick();

		// Assertion
		boolean isSearchedNewsFound = manage_news.isSearchedNewsDisplayed();
		Assert.assertTrue(isSearchedNewsFound, Constant.ERROR_MSG_CreatedNewsSearch);

	}

}