package Selenium.SeleniumFrameworkProjects.TestComponent;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Selenium.SeleniumFrameworkProject.resources.ExtentReporterNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;


public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentText = new ThreadLocal<ExtentTest>(); //Thread safe
	
	@Override
	 public void onTestStart(ITestResult result) {
		//TODO Auto-Generated method stub
		
		test = extent.createTest(result.getMethod().getMethodName());
		extentText.set(test);//unique thread id(ErrorValidationTest)->test
	}
	
	@Override
	 public void onTestSuccess(ITestResult result) {
		//TODO Auto-Generated method stub
		test.log(Status.PASS, "Test Passed");
	}
	
	@Override
	 public void onTestFailure(ITestResult result) {
		//TODO Auto-Generated method stub
		extentText.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentText.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
		//Step-1 take a Screenshot,step-2 attach the report
	}
	}
	
	@Override
	 public void onTestSkipped(ITestResult result) {
		//TODO Auto-Generated method stub
	}
	
	@Override
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//TODO Auto-Generated method stub
	}
	
	@Override
	 public void onStart(ITestContext context) {
		//TODO Auto-Generated method stub
	}
	
	
	@Override
	 public void onFinish(ITestContext context) {
		//TODO Auto-Generated method stub
		extent.flush();
	}
	
}
