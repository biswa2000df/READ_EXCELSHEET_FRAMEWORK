package ToConnectOneSheetToAnother;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass extends BrowserClass {

	// webElement, hello, Action, driver

	static WebElement FROM;
	static String GetText;

	public static void actrds(WebElement element, List<WebElement> elements, String dataField, String actiontype, WebDriver driver)
			throws InterruptedException {

		ActionClass actClass = new ActionClass();

		if (actiontype.equalsIgnoreCase("SendKeys")) {
			element.sendKeys(dataField);
		}

		if (actiontype.equalsIgnoreCase("click")) {
			element.click();
		}

		if (actiontype.contains("WAIT")) {
			String digit = null;
			String string = actiontype;
			Pattern pattern = Pattern.compile("\\((\\d+)\\)"); // Matches digits enclosed in parentheses
			Matcher matcher = pattern.matcher(string);

			if (matcher.find()) {
				digit = matcher.group(1); // Extracts the digit(s) within the parentheses
//		            System.out.println(digit); // Output: 1000
			}
			Long l = Long.parseLong(digit);
			Thread.sleep(l);
		}
		
		if(actiontype.equalsIgnoreCase("STARTBROWSER"))
		{		
			Initialisation(dataField);	
		}

		if (actiontype.equalsIgnoreCase("QUIT")) {

			driver.quit();
		}

		if (actiontype.equalsIgnoreCase("BROWSERURL")) {
			driver.get(dataField);
		}

		if (actiontype.equalsIgnoreCase("MOUSEHOVER")) {
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();

		}
		if (actiontype.equalsIgnoreCase("DOUBLECLICK")) {
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();

		}

		if (actiontype.equalsIgnoreCase("ACTIONCLICK")) {
			Actions act = new Actions(driver);
			act.moveToElement(element).click().build().perform();

		}
		if (actiontype.equalsIgnoreCase("RIGHTCLICK")) {
			Actions act = new Actions(driver);
			act.contextClick(element).click().build().perform();

		}
		if (actiontype.equalsIgnoreCase("MOUSEDRAG")) {
			System.out.println("1");
			FROM = element;
			System.out.println("2");
		}
		if (actiontype.equalsIgnoreCase("MOUSEDROP")) {
			Actions act = new Actions(driver);
			act.dragAndDrop(FROM, element).perform();
		}

		if (actiontype.equalsIgnoreCase("MOUSECLICKSENDKEY")) {
			Actions act = new Actions(driver);
			act.moveToElement(element).click().sendKeys(dataField).perform();
		}

		/////////////// ******************IFRAME*************************//////////////////////////

		if (actiontype.equalsIgnoreCase("FRAMEINDEX")) {
			driver.switchTo().frame(dataField);
			System.out.println("Frame Switch Successfully Using Index");
		}

		if (actiontype.equalsIgnoreCase("FRAMELOCATOR")) {
			driver.switchTo().frame(element);
			System.out.println("Frame Switch Successfully Using Locator");
		}

		if (actiontype.equalsIgnoreCase("DEFAULTFRAME")) {
			driver.switchTo().defaultContent();
		}
		if (actiontype.equalsIgnoreCase("PARENTFRAME")) {
			driver.switchTo().parentFrame();
		}

		if (actiontype.equalsIgnoreCase("FRAMECOUNT")) {
			List<WebElement> count=elements;
			System.out.println("Iframe size are ======================="+count.size());
		}
		
		if(actiontype.equalsIgnoreCase("gettext")) {
			GetText=element.getText();
			System.out.println(GetText);
		}

	}

}
