package testNG.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrderTest {
	
	@Test(invocationCount=10)
	public void createOrderTest() {
		System.out.println("execute createOrdertest==123");
	}
	
	@Test(enabled=false)
	public void billingAnOrdertest() {
		System.out.println("execute billingAnOrderTest=123");
	}
	
	@DataProvider
	public void billingAnOrdertest1() {
		System.out.println("execute billingAnOrderTest=123");
	}
}
