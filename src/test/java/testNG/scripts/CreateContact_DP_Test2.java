package testNG.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 {
	
	@Test(dataProvider="getData")
	public void createContactTest(String firstname,String lastname,Long phno) {
		System.out.println("Firstname:"+firstname+",Lastname"+lastname+",phnumber:"+phno);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		objArr[0][2]=9384930493L;
		objArr[1][0]="sam";
		objArr[1][1]="hd";
		objArr[1][2]=8495849383L;
		objArr[2][0]="John";
		objArr[2][1]="stev";
		objArr[2][2]=6094940393L;
		
		return objArr;
	}
}
