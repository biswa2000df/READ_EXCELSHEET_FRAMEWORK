package excelRead;

import org.openqa.selenium.By;

import com.codoid.products.exception.FilloException;

import ToConnectOneSheetToAnother.ConnectSheet;

public class newMain extends TestBase {

	public newMain(String string) throws FilloException {

		super("https://mail.apmosys.com/webmail/#sign-in");

	}

	static UtilJava java;
	static excelishineread excelread;
	

	public static void main(String[] args) throws FilloException {

		newMain o = new newMain("https://mail.apmosys.com/webmail/#sign-in");
		java = new UtilJava();
		excelread=new excelishineread();

		driver.findElement(By.name("email-address")).sendKeys("bisw");

		excelread.read(); // "java" is object reference
	

		driver.quit();
	}

}
