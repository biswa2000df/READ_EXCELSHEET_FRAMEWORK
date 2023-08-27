package excelRead;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class UtilJava {

	static String RunStatus;
	static String Srno;
	static String Module;
	static String PageName;
	static String ObjectType;
	static String PropertyName;
	static String PropertyValue;
	static String Datafield;
	static String Action;

	public static List<String> ishineDatasheeet() throws FilloException {
		
	Fillo fillo=new Fillo();
	Connection conn=fillo.getConnection("C:\\Users\\biswa\\eclipse-workspace\\READ_EXCELSHEET_FRAMEWORK\\Ishine.xlsx");
	String query="SELECT * FROM Sheet2 WHERE RunStatus='y' ";
	Recordset recordset=conn.executeQuery(query);	
	
	List<String> al=new ArrayList<String>();	
	
	while(recordset.next()) {
		 Srno = recordset.getField("Srno");
//		 Module = recordset.getField("Module");
//		 PageName = recordset.getField("PageName");
	     RunStatus = recordset.getField("RunStatus");
//		 ObjectType = recordset.getField("ObjectType");
		 PropertyName = recordset.getField("PropertyName");
		 PropertyValue = recordset.getField("PropertyValue");
		 Datafield = recordset.getField("Datafield");
		 Action = recordset.getField("Action");
//		String Description = recordset.getField("Description");
//
//		System.out.println(Srno + " " + Module + " " + PageName+" "+RunStatus + " " + ObjectType + " " + PropertyName+" "+PropertyValue + " " + Datafield + " " + Description);
	
		al.add(Srno);
//		al.add(Module);
//		al.add(PageName);
		al.add(RunStatus);
//		al.add(ObjectType);
		al.add(PropertyName);
		al.add(PropertyValue);
		al.add(Datafield);
		al.add(Action);
		
	
		
	}
	return al;
	
	
	
	
//	int count=0;
//	for(int i=0;i<al.size();i=i+9)
//	{
//		Srno=al.get(i);
//		Module=al.get(i+1);
//		PageName=al.get(i+2);
//		RunStatus=al.get(i+3);
//		ObjectType=al.get(i+4);
//		PropertyName=al.get(i+5);
//		PropertyValue=al.get(i+6);
//		Datafield=al.get(i+7);
//		Action=al.get(i+8);
//	
//		if(RunStatus.equalsIgnoreCase(null)) {
//			
//		}
//		else {
////			System.out.println("kanha");
//			System.out.println(RunStatus);
//		count++;}
//	}
//	
//	System.out.println(count);
//	System.out.println(al.size());
//	System.out.println(al);
	
	
	
	

	}

}
