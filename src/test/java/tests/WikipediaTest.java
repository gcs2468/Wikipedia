package tests;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import base.TestBase;
import pages.Wikipedia;

public class WikipediaTest extends TestBase {
	
	Wikipedia wikipedia = new Wikipedia(driver);
	
	@Test
	public void testMethod() {
		seleniumUtils.getUrl();
		
		// Navigate to and validate https://en.wikipedia.org/wiki/OOP
		wikipedia.navigateToOOPPageAndValidateUrl();
		
		// Navigate to and validate https://en.wikipedia.org/wiki/Object-oriented_programming		
		wikipedia.clickonOOPLinkAndValidate();
		seleniumUtils.implicitlyWait(3, TimeUnit.SECONDS);
		
		// Scroll to the bottom of the page and select third name
		wikipedia.scrolldownToBottomOfPage();
		
		
		
	}

}
