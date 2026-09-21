package testNG.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerInvoiceTest {
	
	@Test(retryAnalyzer = listenerUtility.RetryAnalyzerImpCLass.class)
	public void activateSim() {
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("","Login");
		System.out.println("step-1");
		System.out.println("step-2");
	}
}
