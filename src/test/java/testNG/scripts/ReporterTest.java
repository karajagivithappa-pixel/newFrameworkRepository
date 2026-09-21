package testNG.scripts;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterTest {
	
	@Test
	public void t1(Method mtd) {
		
		Reporter.log(mtd.getName()+"Test Start");
		
		Reporter.log("A-1",true);
		Reporter.log("A-2",true);
		
		Reporter.log(mtd.getName()+"Test End");
	}
	
	@Test
	public void t2(Method mtd) {
		
		Reporter.log(mtd.getName()+"Test Start");
		
		Reporter.log("B-1");
		Reporter.log("B-2");
		
		Reporter.log(mtd.getName()+"Test End");
	}
	
}
