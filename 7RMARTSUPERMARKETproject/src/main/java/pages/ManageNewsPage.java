package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement btn_manage_news_new;

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement textarea_news;

	@FindBy(xpath = "//button[@name='create']")
	WebElement btn_save_news;

	// sucess-Alert
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement sucess_news_creation_alert;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement btn_news_search;

	@FindBy(xpath = "//input[@name='un']")
	WebElement txt_enter_search_news;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement btn_search_in_news_search;

	// assertion-locator
	@FindBy(xpath = "//td[text()='Lorem Ipsum is simply dummy text of the printing and typesetting industry.']")
	WebElement locator_news;

	public ManageNewsPage newManageNewsClick() {
		btn_manage_news_new.click();
		return this;
	}

	public ManageNewsPage enterNews(String newsText) {
        textarea_news.sendKeys(newsText);
        return this;
    }

	public ManageNewsPage newManageNewsSaveClick() {
		btn_save_news.click();
		return this;
	}

	// assertion-method
	public boolean isSucessAlertDisplayed() {
		return sucess_news_creation_alert.isDisplayed();
	}

	public ManageNewsPage searchCreatedNewsClick() {
		btn_news_search.click();
		return this;
	}

	public ManageNewsPage enterNewstoSearch(String searchText) {
        txt_enter_search_news.sendKeys(searchText);
        return this;
    }

	public ManageNewsPage searchNewsSearchBtnClick() {
		btn_search_in_news_search.click();
		return this;
	}

	// assertion-method
	public boolean isSearchedNewsDisplayed() {
		return locator_news.isDisplayed();
	}

}