package base;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.SeleniumUtils;

public class TestBase {

	//selenium utility instance
	public static SeleniumUtils seleniumUtils = null;
	
	//selenium WebDriver instance
	public static WebDriver driver;
	

	@BeforeClass
	public static void setup() {
		TestBase tb = new TestBase();
		tb.initWebdriver();
		seleniumUtils = new SeleniumUtils();

	}

	@AfterClass
	public static void afterSuite() {
		driver.quit();
	}

	public String getBrowser() {
		String browser = System.getProperty(Constants.BROWSER);
		if (null == browser) {
			return Constants.CHROME;
		}
		return browser;
	}

	public WebDriver getWebDriver() {
		String browser = getBrowser();
		if(browser.equalsIgnoreCase(Constants.CHROME)) {
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\JunitMavenProject\\src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", "D:\\Eclipse\\JunitMavenProject\\src\\test\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt("10"), TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	public void initWebdriver() {
		driver = getWebDriver();

	}




}
