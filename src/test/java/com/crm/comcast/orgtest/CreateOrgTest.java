package com.crm.comcast.orgtest;
/**
 * @author vithappa
 */
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseutility.BaseClass;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.UtilityClassObject;
import objectRepository.HomePage;
import objectRepository.ContactPage;
import objectRepository.CreatingNewContactPage;
import objectRepository.CreatingNewOrgPage;
import objectRepository.OrgInfoPage;
import objectRepository.OrgPage;
@Listeners(listenerUtility.ListenersImpClass.class)
public class CreateOrgTest extends BaseClass {
	
	@Test(groups = {"smokeTest"})
	public void createOrgTest() throws Exception {
		
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		/* step 1:read testscript data from excel file */
		String orgName=excelUtil.getDataFromExcel("organization",1,2)+javaUtil.randomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to organization module");
		/*step 2:navigate to organization module */
		HomePage home=new HomePage(driver);
		home.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"click on create organization button");
		/*step 3:click on create organization button*/
		OrgPage org = new OrgPage(driver);
		org.getCreateOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO,"enter all details and create new organization");
		/* step 4:enter all details and create new organization */
		CreatingNewOrgPage newOrg = new CreatingNewOrgPage(driver);
		newOrg.getOrgName().sendKeys(orgName);
		newOrg.getSaveBtn().click();
		
		/* step 6:verify org Info name */
		OrgInfoPage orgInfo=new OrgInfoPage(driver);
		String actOrgName=orgInfo.getInfoOrgName().getText();
		Assert.assertEquals(actOrgName.trim(),orgName);
	}
	
	@Test(groups = {"regressionTest"})
	public void createorgWithIndustryTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		/* step 1:read testscript data from excel file */
		String orgName=excelUtil.getDataFromExcel("organization",4,2)+javaUtil.randomNumber();
		String industry=excelUtil.getDataFromExcel("organization",4,3);
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to organization module");
		/*step 2:navigate to organization module */
		HomePage home=new HomePage(driver);
		home.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"click on create organization button");
		/*step 3:click on create organization button*/
		OrgPage org = new OrgPage(driver);
		org.getCreateOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO,"enter all details and create new organization");
		/* step 4:enter all details and create new organization */
		CreatingNewOrgPage newOrg = new CreatingNewOrgPage(driver);
		newOrg.getOrgName().sendKeys(orgName);
		/* select industry */
		driverUtil.selectFromDD(newOrg.getIndustry(),industry);
		newOrg.getSaveBtn().click();
		
		/* step 6:verify org Info name and industry */
		OrgInfoPage orgInfo=new OrgInfoPage(driver);
		String actOrgName=orgInfo.getInfoOrgName().getText();
		Assert.assertEquals(actOrgName.trim(),orgName);
		String actIndustry=orgInfo.getInfoIndustry().getText();
		Assert.assertEquals(actIndustry.trim(),industry);
	}
	
	@Test(groups = {"regressionTest"})
	public void createorgWithPhoneNoTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		/* step 1:read testscript data from excel file */
		String orgName=excelUtil.getDataFromExcel("organization",7,2)+javaUtil.randomNumber();
		String phoneNo=excelUtil.getDataFromExcel("organization",7,3);
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to organization module");
		/*step 2:navigate to organization module */
		HomePage home=new HomePage(driver);
		home.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"click on create organization button");
		/*step 3:click on create organization button*/
		OrgPage org = new OrgPage(driver);
		org.getCreateOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO,"enter all details and create new organization");
		/* step 4:enter all details and create new organization */
		CreatingNewOrgPage newOrg = new CreatingNewOrgPage(driver);
		newOrg.getOrgName().sendKeys(orgName);
		newOrg.getPhone().sendKeys(phoneNo);
		newOrg.getSaveBtn().click();
		
		/* step 5:verify org Info name and phone no */
		OrgInfoPage orgInfo=new OrgInfoPage(driver);
		String actOrgName=orgInfo.getInfoOrgName().getText();
		Assert.assertEquals(actOrgName.trim(),orgName);
		String actPhoneNo=orgInfo.getInfoPhone().getText();
		Assert.assertEquals(actPhoneNo.trim(),phoneNo);
	}
}
