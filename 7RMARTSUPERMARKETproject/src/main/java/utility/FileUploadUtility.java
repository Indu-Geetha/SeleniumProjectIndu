package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

import constant.Constant;

public class FileUploadUtility {

	// 1st apply SendKeys, if not work give robot class
	public void sendKeysForFileUpload(WebElement element, String path) {

		element.sendKeys(path);

	}

	public void robotClassForFileUpload(WebElement element, String path) throws AWTException {

		StringSelection s = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot robot = new Robot();
		robot.delay(2000);
		
		//ctrl+v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(2000);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		
		//enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}