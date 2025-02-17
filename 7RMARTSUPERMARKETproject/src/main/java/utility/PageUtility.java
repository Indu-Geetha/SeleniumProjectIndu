package utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public WebDriver driver;

	public PageUtility(WebDriver driver) {
        this.driver = driver;
    }


	// MethodForSelectByVisible_Text
	public void selectByVisibleText(WebElement element, String visible_txt) {

		Select select = new Select(element);
		select.selectByVisibleText(visible_txt);

	}

	// MethodForSelectByIndex
	public void selectByIndex(WebElement element, int index_value) {
		Select select = new Select(element);
		select.selectByIndex(index_value);

	}

	// MethodForSelectByValue
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	// Method for drag and drop
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();
	}

	// MethodForMouseActions
	public void mouseActions() {
	Actions actions = new Actions(driver);	

	}

	// MethodForJavaScriptExecutor
	public void javaScriptExecutorMethodClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);//perform click action on the button
	}
	
	public void javaScriptExecutorMethodScrollToElement(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element); // Scroll to the specific element
	}

}