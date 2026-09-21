package practice.TestScripts;

import java.io.FileInputStream;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest {
	
	@Test(invocationCount=9)
	public void m1Test() {
		System.out.println("m1");
	}
}
