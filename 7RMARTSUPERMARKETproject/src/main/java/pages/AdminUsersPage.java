package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;
import utility.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	public PageUtility pageutility ;
	public WaitUtility waitUtility;
	

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		this.pageutility = new PageUtility(driver);  // Initialize with driver
        this.waitUtility = new WaitUtility();  // Initialize WaitUtility
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement btn_new;

	@FindBy(xpath = "//input[@id='username']")
	WebElement txt_new_username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txt_new_password;

	@FindBy(xpath = "//select[@id='user_type']")
	WebElement user_type_dropdown;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement btn_save;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement btn_search;

	// sucess-alert-locator
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert_sucess;
	//failure-alert-locator
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert_failure;

	@FindBy(xpath = "//input[@name='un']")
	WebElement txt_search_username;

	@FindBy(xpath = "//select[@id='ut']")
	WebElement user_type_search_drpdwn;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement btn_search_inside_search;

	// after search-locator
	@FindBy(xpath = "//h4[text()='Admin Users']")
	WebElement search_result;
	
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
	WebElement search_no_result;

	// Assertion method-Alert
	public boolean isAlertSucessDisplayed() {
		return alert_sucess.isDisplayed();
	}
	public boolean isAlertFaiureDisplayed() {
		return alert_failure.isDisplayed();
	}

	// Assertion method-search result
	public boolean isSearchResultDisplayed() {
		return search_result.isDisplayed();
	}
	public boolean isSearchResultNotDisplayed() {
		return search_no_result.isDisplayed();
	}

	public AdminUsersPage clickBtnNew() {
		btn_new.click();
		return this;
	}

	public AdminUsersPage enterUsermame(String username_value) {
		txt_new_username.sendKeys(username_value);
		return this;
	}

	public AdminUsersPage enterPassword(String password_value) {
		
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBePresent(driver,txt_new_password);
		
		txt_new_password.sendKeys(password_value);
		return this;
	}

	 public AdminUsersPage selectUserType(String userType) {  // Now dynamic!
	        pageutility.selectByVisibleText(user_type_dropdown, userType);
	        return this;
	 }

	public AdminUsersPage clickSave() {

		WaitUtility wait = new WaitUtility();
		wait.waitToElementClick(driver, btn_save);

		btn_save.click();

		return this;
	}

	public AdminUsersPage clickBtnSearch() {
		btn_search.click();
		return this;
	}

	public AdminUsersPage enterSearchUsermame(String search_username_value) {
		txt_search_username.sendKeys(search_username_value);
		return this;
	}

	public AdminUsersPage selectUserTypeSearch(String userType) {

		pageutility.selectByVisibleText(user_type_search_drpdwn, userType);
		return this;
	}

	public AdminUsersPage clickBtnSearchInsideSearch() {
		btn_search_inside_search.click();
		return this;
	}
	

}