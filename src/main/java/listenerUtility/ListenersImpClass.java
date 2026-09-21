package listenerUtility;

import java.io.File;
import java.io.IOException;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.baseutility.BaseClass;

import genericUtility.UtilityClassObject;

public class ListenersImpClass implements ITestListener, ISuiteListener {
	
	static ExtentReports report;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time = new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/extentreport"+time+".html");
		spark.config().setDocumentTitle("CRM Test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		if(report !=null) {
		report.flush();
	}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String method = result.getMethod().getMethodName();
		System.out.println("---" + method + " START---");
		ExtentTest test = report.createTest(method);
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO,result.getMethod().getMethodName()+"--> STARTED <--");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("---" + result.getMethod().getMethodName() + " END---");
		UtilityClassObject.getTest().log(Status.PASS,result.getMethod().getMethodName()+"--> COMPLETED <--");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ","_").replace(":","_");
		
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath,testName+time);
		UtilityClassObject.getTest().log(Status.FAIL,result.getMethod().getMethodName()+"--> FAILED <--");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}