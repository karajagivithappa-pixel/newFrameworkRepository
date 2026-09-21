package com.crm.generic.baseutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.UtilityClassObject;
import genericUtility.WebDriverUtility;
import objectRepository.HomePage;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreatingNewContactPage;
import objectRepository.CreatingNewOrgPage;
import objectRepository.LoginPage;
import objectRepository.OrgInfoPage;
import objectRepository.OrgPage;

public class BaseClass {

	public PropertyUtility propUtil = new PropertyUtility();
	public WebDriverUtility driverUtil = new WebDriverUtility();
	public WebDriver driver;
	public JavaUtility javaUtil = new JavaUtility();
	public ExcelUtility excelUtil = new ExcelUtility();
	
	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() {
		System.out.println("----connect to DB,report config----");
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() throws Exception {
		System.out.println("---launch browser---");
		//String browserName=browser;
		String browserName = propUtil.getData("browser");

		driver = driverUtil.launchDriver(browserName);
		UtilityClassObject.setDriver(driver);
		driverUtil.maximizeBrowser(driver);
		driverUtil.implicitWait(driver);
		driver.get(propUtil.getData("url"));
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Exception {
		System.out.println("--login--");
		LoginPage l = new LoginPage(driver);
		l.userLogin(propUtil.getData("username"), propUtil.getData("password"));
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() throws Exception {
		HomePage home=new HomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(home.getUserImg()).pause(Duration.ofSeconds(2)).click(home.getSignout()).build().perform();
		System.out.println("--logout--");
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		driver.quit();
		System.out.println("---close browser---");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() {
		System.out.println("----close DB,report backUP----");
	}
}
