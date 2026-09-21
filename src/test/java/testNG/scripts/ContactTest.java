package testNG.scripts;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class ContactTest {
	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest with hdfc");
		System.out.println(10/0);
	}
	@Test(dependsOnMethods="createContactTest")
	public void modifyContactTest() {
		System.out.println("execute modifyContactTest from hdfc to icici");
	}
	@Test(dependsOnMethods="modifyContactTest")
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest icici");
	}
}
