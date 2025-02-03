package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utility.ExcelUtility;

public class SubCategoryTest extends Base {
	public HomePage home;
	public SubCategoryPage subcategory;

	@Test(priority = 1)
	public void verifyCreationOfNewSubCategory__FileUploadUsingSendKeys() throws IOException {
		String username_valid = ExcelUtility.getStringData(1, 0, "SubCategoryPageTestData");
		String password_valid = ExcelUtility.getStringData(1, 1, "SubCategoryPageTestData");

		String subcategory_type = ExcelUtility.getStringData(2, 0, "SubCategoryPageTestData");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username_valid, password_valid);
		home = login.clickSignInButton();
		subcategory = home.subCategoryClick();
		subcategory.subCategoryNewBtnClick();
		subcategory.selectCategoryDrp();
		subcategory.enterSubCategory(subcategory_type);
		subcategory.uploadSubCategoryImage_SendKeys();
		subcategory.clickBtnSaveSubCategory();

		// Assertion
		boolean isSucessfullyNewSubCategoryCreated = subcategory.isNewSubCategoryCreated();
		Assert.assertTrue(isSucessfullyNewSubCategoryCreated, Constant.ERROR_MSG_CreationOfNewSubCategory);

	}

}