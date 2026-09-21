package testNG.scripts;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTest {

	@Test
	public void t1(Method mtd) {

		System.out.println(mtd.getName() + " Test Start");

		System.out.println("A-1");
		Assert.assertEquals("Home","Hom");
		System.out.println("A-2");

		System.out.println(mtd.getName() + " Test End");
	}

	@Test
	public void t2(Method mtd) {
		SoftAssert soft=new SoftAssert();
		System.out.println(mtd.getName() + " Test Start");

		System.out.println("B-1");
		soft.assertTrue(false);
		System.out.println("B-2");
		
		System.out.println(mtd.getName() + " Test End");
		soft.assertAll();
	}

}
