package testNG.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

@Listeners(listenerUtility.ListenersImpClass.class)
public class Listener_InvoiceTest extends BaseClass{
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String actTitle=driver.getTitle();
		//use assert to validate the result
		//intentionally fail the test case
		Assert.assertEquals(actTitle,"login");
		System.out.println("step-1");
		System.out.println("step-2");
	}
	
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoiceWithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
	}
}
