package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Constants;

import static base.TestBase.driver;


public class SeleniumUtils {

	public int explicitWait;
	public int pageRefreshWait;


	public SeleniumUtils() { 	}
	
	public void getUrl() {
		driver.get(Constants.Url);
	}

	/**
	 * Find element with given parameter.
	 */
	public WebElement findElement(WebDriver driver, Identifier identifier, String locator) {
		By by = getByLocator(identifier, locator);
		return driver.findElement(by);
	}

	/**
	 * Find all element with given parameter.
	 */
	public List<WebElement> findElements(WebDriver driver, Identifier identifier, String locator) {
		By by = getByLocator(identifier, locator);
		return driver.findElements(by);
	}

	public By getByLocator(Identifier identifier, String locator) {
		By by = null;
		switch (identifier) {
		case ID:
			by = By.id(locator);
			break;
		case NAME:
			by = By.name(locator);
			break;
		case CLASS_NAME:
			by = By.className(locator);
			break;
		case CSS:
			by = By.cssSelector(locator);
			break;
		case XPATH:
			by = By.xpath(locator);
			break;
		}
		return by;
	}

	/**
	 * Send text key to webelement. Clear the text before sending the key.
	 */
	public void sendKeys(WebElement webElement, String text) {
		webElement.clear();
		implicitlyWait(10, TimeUnit.SECONDS);
		webElement.sendKeys(text);
	}

	public void implicitlyWait(int timeOut, TimeUnit timeUnit){
		driver.manage().timeouts().implicitlyWait(timeOut, timeUnit);
	}
	
	public enum Identifier {ID, NAME, CLASS_NAME, CSS, XPATH}

	

}
