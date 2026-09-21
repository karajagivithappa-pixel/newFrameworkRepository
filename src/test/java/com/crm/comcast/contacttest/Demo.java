package com.crm.comcast.contacttest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Demo {
	@Test
	public void A() {
		System.out.println("A");
	}
	
	@Ignore
	public void B() {
		System.out.println("B");
	}
	
	@Test
	public int C() {
		System.out.println("C");
		return 10;
	}
}
