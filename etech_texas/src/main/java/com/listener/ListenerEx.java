package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.TestBase;
import com.aventstack.extentreports.Status;

public class ListenerEx extends TestBase implements ITestListener  {

	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test case passed with name as "+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "test case failed with name as "+result.getName());
		test.addScreenCaptureFromPath(captureScreenshot(result.getName()));
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "test case skipped with name as "+result.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	public void onStart(ITestContext context) {
		reportInit();
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
