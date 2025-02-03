package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.manage().window().maximize();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}