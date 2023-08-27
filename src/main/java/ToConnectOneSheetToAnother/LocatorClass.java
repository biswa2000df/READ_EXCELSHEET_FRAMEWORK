package ToConnectOneSheetToAnother;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;

import excelRead.TestBase;

public class LocatorClass extends BrowserClass {

	public LocatorClass() throws FilloException {
		super();
		// TODO Auto-generated constructor stub
	}

	LocatorClass xget;
	WebElement webElement;
	List<WebElement> webElements;
	ActionClass actClass;
	ConnectSheet conSheet;

	public void xpathpick(String LOCATOR, String LocatorElement, String Datafield, String Action, WebDriver driver)
			throws FilloException, InterruptedException {
		xget = new LocatorClass();
		actClass=new ActionClass();
		conSheet=new ConnectSheet();

		By by;

		if ((LOCATOR != null && !LOCATOR.isEmpty() && LocatorElement != null && !LocatorElement.isEmpty())) {

			if (LOCATOR.equalsIgnoreCase("xpath")) {
				by = By.xpath(LocatorElement);
			} else if (LOCATOR.equalsIgnoreCase("id")) {
				by = By.id(LocatorElement);
			} else if (LOCATOR.equalsIgnoreCase("name")) {
				by = By.name(LocatorElement);
			} else if (LOCATOR.equalsIgnoreCase("css")) {
				by = By.cssSelector(LocatorElement);
			} else if (LOCATOR.equalsIgnoreCase("tagName")) {
				by = By.tagName(LocatorElement);
			} else {
				// Handle unsupported LOCATOR type
				throw new IllegalArgumentException("Unsupported LOCATOR type: " + LOCATOR);
			}
			webElement = driver.findElement(by);
			webElements = driver.findElements(by);
//			actClass.actrds();
			conSheet.DataFieldRead(webElement, webElements, Datafield, Action , driver);
		}
		
		else
		{
			conSheet.DataFieldRead(webElement, webElements, Datafield, Action , driver);
		}
		
	}
}
