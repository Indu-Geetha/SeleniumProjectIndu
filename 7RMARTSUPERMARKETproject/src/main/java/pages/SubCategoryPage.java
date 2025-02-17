package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utility.FileUploadUtility;
import utility.PageUtility;
import utility.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility(driver);
	FileUploadUtility fileupload = new FileUploadUtility();
	WaitUtility wait = new WaitUtility();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement subcategorypage_btn_new;

	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement category_drp_locator;

	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement txt_subcategory;

	@FindBy(xpath = "//input[@name='main_img']")
	WebElement btn_file_upload;

	@FindBy(xpath = "//button[@name='create']")
	WebElement btn_Save_subCategory;

	// alert locator
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement subcategory_new_sucess;

	public SubCategoryPage subCategoryNewBtnClick() {
		subcategorypage_btn_new.click();
		return this;
	}

	public SubCategoryPage selectCategoryDrp() {

		pageutility.selectByValue(category_drp_locator, "557");// WebElement ,value pass
		return this;
	}

	public SubCategoryPage enterSubCategory(String type_subcategory) {
		txt_subcategory.sendKeys(type_subcategory);
		return this;
	}

	public SubCategoryPage uploadSubCategoryImage_SendKeys() {

		wait.waitForVisibilityOfElement(driver, btn_file_upload);
		fileupload.sendKeysForFileUpload(btn_file_upload, Constant.IMAGE);

		return this;
	}

	public SubCategoryPage clickBtnSaveSubCategory() {
		btn_Save_subCategory.click();
		return this;
	}

	// Assertion
	public boolean isNewSubCategoryCreated() {
		return subcategory_new_sucess.isDisplayed();
	}

}