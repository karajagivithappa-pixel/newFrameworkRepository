package com.crm.comcast.contacttest;
/**
 * @author vithappa
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseutility.BaseClass;

import genericUtility.UtilityClassObject;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreatingNewContactPage;
import objectRepository.CreatingNewOrgPage;
import objectRepository.HomePage;
import objectRepository.OrgInfoPage;
import objectRepository.OrgPage;
@Listeners(listenerUtility.ListenersImpClass.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = { "smokeTest" })
	public void createContactTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		/*step 1:read data from excel and javautility */
		String lastName = excelUtil.getDataFromExcel("contact", 1, 2)+javaUtil.randomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact module");
		/* Step 2:navigate to contact module */
		HomePage home=new HomePage(driver);
		home.getContactLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"click on create contact button");
		/* step 3:click on "create contact" button */
		ContactPage contact = new ContactPage(driver);
		contact.getCreateContact().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"create and save new contact");
		/* step 4:enter all details and create new contact */
		CreatingNewContactPage newContact = new CreatingNewContactPage(driver);
		newContact.getLastName().sendKeys(lastName);
		newContact.getSave().click();

		/* step 5:Use Assert to verify
		verify lastName using info page */
		ContactInfoPage contactInfo = new ContactInfoPage(driver);
		String actLastName = contactInfo.getInfoLastName().getText();
		Assert.assertEquals(actLastName.trim(), lastName);
	}

	@Test(groups = { "regressionTest" })
	public void createContactWithSupportDateTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel and utility");
		/*step 1:read data from excel and javautility */
		String lastName = excelUtil.getDataFromExcel("contact", 4, 2)+javaUtil.randomNumber();
		String supStartDate = javaUtil.currectDate();
		String supEndDate = javaUtil.endDate();

		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact module");
		/* Step 2:navigate to contact module */
		HomePage home=new HomePage(driver);
		home.getContactLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"click on create contact button");
		/* step 3:click on "create contact" button */
		ContactPage contact = new ContactPage(driver);
		contact.getCreateContact().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"create and save new contact");
		/* step 4:enter all details and create new contact */
		CreatingNewContactPage newContact = new CreatingNewContactPage(driver);
		newContact.getLastName().sendKeys(lastName);
		newContact.getStartDate().clear();
		newContact.getStartDate().sendKeys(supStartDate);
		
		newContact.getEndDate().clear();
		newContact.getEndDate().sendKeys(supEndDate);
		newContact.getSave().click();

		/* step 5:verify lastName and support dates 
		   using contact info page */
		ContactInfoPage contactInfo = new ContactInfoPage(driver);
		String actLastName = contactInfo.getInfoLastName().getText();
		Assert.assertEquals(actLastName.trim(), lastName);

		String actInfoEndDate = contactInfo.getInfoEndDate().getText();
		String actInfoStartDate=contactInfo.getInfoStartDate().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actInfoEndDate, supEndDate);
		soft.assertEquals(actInfoStartDate,supStartDate);
		soft.assertAll();
	}

	@Test(groups = { "regressionTest" })
	public void createContactWithOrgTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel and utility");
		/*step 1:read data from excel and javautility */
		String orgName = excelUtil.getDataFromExcel("organization", 1, 2) +javaUtil.randomNumber();
		String lastName = excelUtil.getDataFromExcel("contact", 1, 2)+javaUtil.randomNumber();

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
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact module");
		/*step 5:navigate to contact module */
		home.getContactLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"click on create contact button");
		/* step 6:click on "create contact" button */
		ContactPage contact = new ContactPage(driver);
		contact.getCreateContact().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"create and save new contact");
		/* step 7:enter all details and create new contact */
		CreatingNewContactPage newContact = new CreatingNewContactPage(driver);
		newContact.getLastName().sendKeys(lastName);
		
		newContact.getOrgSelectBtn().click();
		String parentId = driver.getWindowHandle();
		
		/*switch window to perform actions */
		driverUtil.switchToChildWindow(driver, parentId);
		driver.findElement(By.id("search_txt")).sendKeys(orgName, Keys.ENTER);
		driver.findElement(By.linkText(orgName)).click();
		driverUtil.switchToParentWindow(driver, parentId);
		newContact.getSave().click();

		// Use Assert to verify
		// verify lastName using info header
		ContactInfoPage contactInfo = new ContactInfoPage(driver);
		String actLastName = contactInfo.getInfoLastName().getText();
		Assert.assertEquals(actLastName.trim(), lastName);
	}

}
