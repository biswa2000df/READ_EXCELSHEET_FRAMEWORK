package excelRead;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;

public class excelishineread {
//	UtilJava java;

	public void read() throws FilloException {
		
		List<String> al1=new ArrayList<String>();
		
		
//		java = new UtilJava();
		al1=UtilJava.ishineDatasheeet();
		
		System.out.println(al1);
	}

}
