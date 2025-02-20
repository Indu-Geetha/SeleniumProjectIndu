package pages;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utility.FileUploadUtility;
import utility.PageUtility;
import utility.WaitUtility;

public class CATEGORY2 {

	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	FileUploadUtility fileupload = new FileUploadUtility();
	PageUtility page = new PageUtility(driver);

	public CATEGORY2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement btn_category_new;

	@FindBy(xpath = "//input[@id='category']")
	WebElement txt_category_input;

	@FindBy(xpath = "//li[@id='134-selectable']") 
	WebElement box_select_groups;

	@FindBy(xpath = "//input[@type='file']")
	WebElement btn_choose_file;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement btn_save;

//alert	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert_locator;

	// delete
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement btn_delete;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert_locator_delete;

	public CATEGORY2 btnCategoryNewClick() {
		btn_category_new.click();
		return this;
	}

	public CATEGORY2 nameCategory(String category_name) {
		txt_category_input.sendKeys(category_name);
		return this;
	}

	public CATEGORY2 btnDiscountClick() {
		box_select_groups.click();
		return this;
	}

	public CATEGORY2 btnFileClick() {
		btn_choose_file.click();
		return this;
	}

	public CATEGORY2 fileUploadSendKeys() throws AWTException, InterruptedException {
		wait.waitForVisibilityOfElement(driver, btn_choose_file);
		fileupload.sendKeysForFileUpload(btn_choose_file, Constant.IMAGE);
		return this;
	}

	public CATEGORY2 btnCategorySaveClick() {

		PageUtility pageutil=new PageUtility(driver);
		pageutil.javaScriptExecutorMethodClick(btn_save);
		return this;
	}

	public boolean isCategoryCreatedSucessDisplayed() {
		return alert_locator.getText().contains("Success");
	}

	public CATEGORY2 btnCategoryDeleteClick() {
		btn_delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}

	public boolean isCategoryDeleted() {
		return alert_locator_delete.isDisplayed();
	}

}