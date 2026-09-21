package testNG.scripts;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTest{
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report1.html");
		spark.config().setDocumentTitle("CRM Test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("browser", "Chrome-100");
	}

	@AfterSuite
	public void configAS() {
		report.flush();
	}

	@Test
	public void createContactTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.29.4:8888/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("hdfc".equals("hdc"))
			test.log(Status.PASS,"contact is created");
		else
			test.addScreenCaptureFromBase64String(filepath,"ErrorFIle");

	}
	
	@Test
	public void createContactWithOrg() {
		ExtentTest test = report.createTest("createContactWithOrg");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("hdfc".equals("hdfc"))
			System.out.println("contact is created");
		else
			System.out.println("contact not created");

	}
	
	@Test
	public void createContactWithPhone() {
		ExtentTest test = report.createTest("createContactWithPhone");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("hdfc".equals("hdfc"))
			System.out.println("contact is created");
		else
			System.out.println("contact not created");

	}
}
