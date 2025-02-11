package testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constant.Constant;
import utility.ScreenshotUtility;

public class Base {
	public Properties properties;
	public FileInputStream fis;

	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browzer")
	public void setUp(String browzer) throws Exception {
		try {
			properties = new Properties();
			fis = new FileInputStream(Constant.CONFIG_FILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browzer.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browzer.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browzer.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
		// driver=new ChromeDriver();

		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown(ITestResult itResult) throws IOException {
		// driver.quit();
		if (itResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility sc = new ScreenshotUtility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
		if (driver != null) {
			driver.quit();
		}
	}

}