package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class CategoryTest extends Base {
	public HomePage home;
	public CategoryPage category;

	@Test(priority = 1)
	public void verifyCreationOfNewCategoryInCategoryPage() throws IOException, AWTException, InterruptedException {
		String username_valid = ExcelUtility.getStringData(1, 0, "CategoryPageTestData");
		String password_valid = ExcelUtility.getStringData(1, 1, "CategoryPageTestData");
		String category_name = ExcelUtility.getStringData(3, 0, "CategoryPageTestData");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username_valid, password_valid);
		
		home = login.clickSignInButton();
		
		category = home.categoryClick();
		category.btnCategoryNewClick();
		category.nameCategory(category_name);
		category.btnDiscountClick();
		category.fileUploadSendKeys();
		category.btnCategorySaveClick();

		// Assertion
		boolean isSucessfullyNewCategoryCreated = category.isCategoryCreatedSucessDisplayed();
		Assert.assertTrue(isSucessfullyNewCategoryCreated, Constant.ERROR_MSG_CreationOfNewCategory);

	}

	@Test(priority = 2)
	public void verifyDeleteOfCategory() throws IOException {
		String username_valid = ExcelUtility.getStringData(1, 0, "CategoryPageTestData");
		String password_valid = ExcelUtility.getStringData(1, 1, "CategoryPageTestData");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username_valid, password_valid);
		home = login.clickSignInButton();
		category = home.categoryClick();
		category.btnCategoryDeleteClick();

		// Assertion
		boolean isSucessfullyDeletedTopmostCategory = category.isCategoryDeleted();
		Assert.assertTrue(isSucessfullyDeletedTopmostCategory, Constant.ERROR_MSG_CreationOfNewCategory);
	}
	

}