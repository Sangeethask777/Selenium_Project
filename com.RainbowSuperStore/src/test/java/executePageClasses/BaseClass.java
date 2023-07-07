package executePageClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Screenshot;

public class BaseClass {

	WebDriver driver;
	Screenshot sh;
	static Properties property;
	static FileInputStream f;
	
	
public static void readProperty() throws IOException
{
	property=new Properties();
	f = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\Config.properties");
	property.load(f);
}
	@Parameters({"Browser"})
	@BeforeMethod(groups = {"open"})
	public void beforeMethod(String browserValue) throws IOException {
		
		readProperty();
		
		if(browserValue.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if (browserValue.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod(groups = {"close"})
	public void afterMethod(ITestResult it) throws IOException {
		
		if(it.getStatus()==ITestResult.FAILURE)
		{
			sh=new Screenshot();
			sh.takeScreenShot(driver, it.getName());
		}

		driver.quit();

	}

	@BeforeSuite(alwaysRun = true)
	public void createReport(final ITestContext testContext) {
		extendReport.ExtentManager.createInstance().createTest(testContext.getName(), "message");
	}
	
}