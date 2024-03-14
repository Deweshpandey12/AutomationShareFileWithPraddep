package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) 
	{	
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----------test execution started---------");
		
		//create a test for  @Test in extent report
		test = report.createTest(methodName);
	}

	
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----------Test pass --------");
		
		//log the pass status in extent reports
		test.log(Status.PASS, methodName+"-----------Test pass --------");
	}

	
	public void onTestFailure(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----------Test Fail --------");
		//log the Fail status in extent reports
		test.log(Status.FAIL, methodName+"-----------Test Fail --------");
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		String screenShotname = methodName +"-" +j.getDate();
		
		//log the Fail status in extent reports
		test.log(Status.FAIL, methodName+"-----------Test Fail --------");

		try {
			
			String path = s.captureScreenShot(BaseClass.sdriver, screenShotname);
			
			//Attach the Screen shot for extent reports
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----------Test skip ---------");
		
		//log the Skip status in extent reports
		test.log(Status.SKIP, methodName+"-----------Test Skip --------");

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) 
	{	
		System.out.println("-----------Suite execution started ---------");
		
		//Configure the extent reports
		ExtentSparkReporter rep = new ExtentSparkReporter("./ExtentReports/Report-"+new JavaUtility().getDate() +".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setTheme(Theme.DARK);
		rep.config().setReportName("Vtiger execution report");
		
		report = new ExtentReports();
		
		report.attachReporter(rep);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base PlatForm", "Testing");
		report.setSystemInfo("Base OS", "Linux");
		report.setSystemInfo("Base URL", "https://demo.vtiger.com/vtigercrm/index.php");
		
		
		
	}

	
	public void onFinish(ITestContext context) 
	{
		System.out.println("-----------Suite execution Finished ---------");
		
		//generate extent report
		report.flush();
	}
	
}
