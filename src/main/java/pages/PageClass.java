package pages;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class PageClass {

	private WebDriver driver;
    private Properties properties;
    private SeleniumUtils seleniumUtils;




	// *********** XPATHS ****************************

	@FindBy(xpath = "//td[@class='tabs']//table")
	private List<WebElement> eCatNodes;

	@FindBy(xpath = "//*[@id='sliderContent']//table//tbody//tr//td")
	private List<WebElement> eCatSubNodesCount;

	private String webElementNode = "//span[@id='tabLabel$$']";






	// *********** CONSTRUCTOR ****************************

	PageClass(WebDriver driver, Properties properties, SeleniumUtils seleniumUtils){

		this.driver = driver;
		this.properties = properties;
		AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(ajaxFactory, this);
	}

	// *********** TEST METHODS ****************************

	public int numberOfNodes() {
		List<WebElement> listofNodes = eCatNodes;
		int numberOfNodes = listofNodes.size();
		return numberOfNodes;
	}

	public List<String> captureNameOfNode() {
		int numberOfNodes = numberOfNodes();
		List<String> namesOfNodes = new LinkedList<>();
		for (int node = 0; node < numberOfNodes; node++) {
			String webElementLocator = webElementNode.replace("$$", String.valueOf(node));
			WebElement eCatNameOfNode = seleniumUtils.findElement(driver, SeleniumUtils.Identifier.XPATH, webElementLocator);
			String nameOfNode = eCatNameOfNode.getText().replaceAll("[/?:]", "|");
			namesOfNodes.add(nameOfNode);
		}
		return namesOfNodes;
	}


}
