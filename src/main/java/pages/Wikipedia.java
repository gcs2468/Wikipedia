package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Wikipedia {

	private WebDriver driver;
	Actions builder;


	// *********** XPATHS ****************************

	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchBox;

	@FindBy(xpath = "//a[text()='Object-oriented programming']")
	private WebElement oOPLink;
	
	@FindBy(xpath = "//a[text()='Grady Booch']")
	private WebElement thirdName;


	// *********** CONSTRUCTOR ****************************

	public Wikipedia(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(ajaxFactory, this);
	}

	// *********** METHODS ****************************

	public void navigateToOOPPageAndValidateUrl() {
		searchBox.sendKeys("OOP");
		builder=new Actions(driver);
		builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).click().build().perform();
		String expectedUrl = "https://en.wikipedia.org/wiki/OOP";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Expected and actual urls by clicking on OOP in suggestions");
		System.out.println();
		System.out.println("Expected url is :: "+expectedUrl);
		System.out.println("Actual url is :: "+actualUrl);
		System.out.println();
		Assert.assertTrue(actualUrl.equals(expectedUrl));

	}

	public void clickonOOPLinkAndValidate() {
		oOPLink.click();
		String expectedUrl = "https://en.wikipedia.org/wiki/Object-oriented_programming";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Expected and actual urls by clicking on Object-oriented_programming");
		System.out.println();
		System.out.println("Expected url is :: "+expectedUrl);
		System.out.println("Actual url is :: "+actualUrl);
		System.out.println();
		Assert.assertTrue(actualUrl.equals(expectedUrl));
	}

	
	// PageDown to bottom and get the third name from the list.
	public void scrolldownToBottomOfPage() {

		builder=new Actions(driver);
		for(int i=0; i<=12; i++) {
			builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
		String engiName = thirdName.getText();
		System.out.println("Third name from the list is :: "+engiName);


	}

















}
