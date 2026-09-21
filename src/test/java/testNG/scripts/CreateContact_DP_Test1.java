package testNG.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test1 {
	 
	@Test(dataProvider="getData")
	public void createContactTest(String firstname,String lastname) {
		System.out.println("Firstname:"+firstname+",Lastname:"+lastname);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object [][] objArr=new Object[3][2];
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		objArr[1][0]="sam";
		objArr[1][1]="hd";
		objArr[2][0]="John";
		objArr[2][1]="stev";
		
		return objArr;
	}
}
