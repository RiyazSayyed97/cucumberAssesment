package abstracted;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
import pages.ContactMe;
import utils.ExentReport;
import utils.Screenshot;

public class CustomisedRunner extends AbstractTestNGCucumberTests {
	private ExtentReports report;
	private ExtentTest logger;
	private TestNGCucumberRunner testNGCucumberRunner;

	@Parameters({ "browser" })
	@BeforeTest
	public void setupTest(String browser) throws IOException {
		ContactMe.openURL(browser);
	}

	@BeforeClass(alwaysRun = true)
	public void setUPClass() throws IOException {

		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		System.out.println("test started");
		report = ExentReport.init();
		logger = report.startTest("ContactMetest");
	}

	@AfterClass
	public void afterClass() {
		report.endTest(logger);
		report.flush();

		testNGCucumberRunner.finish();
	}

	@AfterMethod
	public void f1(ITestResult i) throws IOException {
		if (i.getStatus() == ITestResult.FAILURE) {
			String path = Screenshot.takeScreenshotAs(ContactMe.driver, i.getName());
			String imagepath = logger.addScreenCapture(path);
			logger.log(LogStatus.FAIL, "test failed", imagepath);
		} else if (i.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.FAIL, "test skipped");
		} else {
			logger.log(LogStatus.PASS, "method Passed");
		}
	}

}
