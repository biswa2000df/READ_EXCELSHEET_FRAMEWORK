package excelRead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	Connection conn;
	static String browser;

	public TestBase(String url) throws FilloException {

		Fillo filo = new Fillo();
		conn = filo.getConnection("C:\\Users\\biswa\\eclipse-workspace\\READ_EXCELSHEET_FRAMEWORK\\MainControler.xlsx");
		String query = "SELECT * FROM Sheet1 WHERE RUNSTATUS='Y' ";

		Recordset recordset = conn.executeQuery(query);
		while (recordset.next()) {

			browser = recordset.getField("BROWSER");
			System.out.println(browser);
			Initialisation(url);
		}

	}

	public static void Initialisation(String url) {
		
		System.out.println("This is the "+ browser);
		
				if(browser.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					ChromeOptions option = new ChromeOptions();
					option.addArguments("--remote-allow-origins=*");
					driver = new ChromeDriver(option);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				}
				
				else if(browser.equalsIgnoreCase("edge")){
					WebDriverManager.edgedriver().setup();
					EdgeOptions option = new EdgeOptions();
					option.addArguments("--remote-allow-origins=*");
					driver = new EdgeDriver(option);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
				}
				
				
				driver.get(url);
				
				
				
				
				
			}

}
