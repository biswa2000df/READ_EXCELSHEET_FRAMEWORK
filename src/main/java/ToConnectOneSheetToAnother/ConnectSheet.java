package ToConnectOneSheetToAnother;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ConnectSheet extends BrowserClass {

//	public static void main(String[] args) throws FilloException {
//		System.out.println("Hello");
//		m1();
//	}

	static String LOCATOR;
	static String PropertyValue;
	static String Datafield;
	static String Action;
	static LocatorClass xget;
	static ConnectSheet consheet;
	public static void DataSheetGet() throws FilloException, InterruptedException {
		consheet=new ConnectSheet();
		xget=new LocatorClass();

		Fillo fillo = new Fillo();
		Connection conn = fillo.getConnection(System.getProperty("user.dir") + "\\kanha30.xlsx");
		String query = "SELECT * FROM Sheet4 WHERE RUNSTATUS='Y'";
		Recordset recordset = conn.executeQuery(query);

		// new type***************************************

		List<Object> rowsList = new ArrayList<>();

		while (recordset.next()) {
			List<String> columns = recordset.getFieldNames();
			List<Object> rowValues = new ArrayList<>();
			for (String column : columns) {
				rowValues.add(recordset.getField(column));
			}
			rowsList.add(rowValues);
		}
		
		

		// this type is working properly****************************

//		List<String> al = new ArrayList<String>();
//		while (recordset.next()) {
//			LOCATOR=recordset.getField("LOCATOR");
//			PropertyValue = recordset.getField("PropertyValue");
//			Datafield = recordset.getField("Datafield");
//			Action = recordset.getField("Action");
//			al.add(LOCATOR);
//			al.add(XPATH);
//			al.add(Datafield);
//			al.add(Action);
//		}******************************************************

//		for (Object o : rowsList) {
//			System.out.println(o);
//		}

		// **************************************************

//		System.out.println(rowsList);

//		return rowsList;
		
		int j;
		for(int i=0;i<rowsList.size();i++) {
			
			 List<Object> row = (List<Object>) rowsList.get(i);
			 
			 for( j=1;j<row.size();j++)
			 {
				 if(j==1)
				 {
					 LOCATOR=(String) row.get(j);
				 }
				 
				 else if(j==2) {
					 PropertyValue=(String) row.get(j);
				 }
				 
				 else if(j==3) {
					 Datafield=(String) row.get(j);
				 }
				 
				 else if(j==4) {
					 Action=(String) row.get(j);
				 }

			 }
			 System.out.println("LOCATOR NAME=========================>"+LOCATOR+"\n"+"PropertyValue====================>"+PropertyValue+"\n"+"Datafield=============>"+Datafield+"\n"+"ActionType========>"+Action);
			 
			 
			 
			 xget.xpathpick(LOCATOR, PropertyValue, Datafield, Action, driver);
			 
			 
			
		}

	}

	//////////////////////////////////////// DataField Read
	//////////////////////////////////////// kariba//////////////////////////////

	static String hello;
	static ActionClass actClass;

	public static void DataFieldRead(WebElement webElement, List<WebElement> webElements, String Datafield,
			String Action, WebDriver driver) throws FilloException, InterruptedException {
		actClass = new ActionClass();
		if (Datafield != null && !Datafield.isEmpty())

		{

			Fillo fillo = new Fillo();
			Connection conn = fillo.getConnection(System.getProperty("user.dir") + "\\kanha30.xlsx");
			String query = "SELECT * FROM Sheet5";
			Recordset recordset = conn.executeQuery(query);
			while (recordset.next()) {
				hello = recordset.getField(Datafield);
				System.out.println(
						"DataFiels For Sheet2====================================================" + hello);
				actClass.actrds(webElement, webElements, hello, Action, driver);

			}
		}

		else {
			actClass.actrds(webElement, webElements, hello, Action, driver);
		}

	}

}
