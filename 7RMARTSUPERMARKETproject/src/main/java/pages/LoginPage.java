package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement txt_usename;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_password;

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement dashboard_text;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement btn_signIn;

	// Assertion method
	public boolean isDashboardTextDisplayed() {
		return dashboard_text.isDisplayed();
	}

	public LoginPage setUserNamePassword(String user_name, String pass_word) {
		txt_usename.sendKeys(user_name);
		txt_password.sendKeys(pass_word);
		return this;
	}

	public HomePage clickSignInButton() {
		btn_signIn.click();
		return new HomePage(driver);

	}

	// Alert-locator
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert_invalid_username_password_locator;

	// Assertion method-Alert
	public boolean isAlertMessageDisplayed() {
		return alert_invalid_username_password_locator.isDisplayed();
	}
	
	//Assertion -logout
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	WebElement Sign_in_to_start_your_session;

	public boolean isSignintostartyoursessionDisplayed() {
		return Sign_in_to_start_your_session.isDisplayed();
	}
}