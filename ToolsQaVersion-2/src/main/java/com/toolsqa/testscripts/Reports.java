package com.toolsqa.testscripts;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/login.html");
	ExtentReports extent = new ExtentReports();
	public void reportLog() throws IOException {
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Toolsqa");
		logger.log(Status.INFO, "pass");
		logger.log(Status.PASS, "pass report");
		logger.fail("Account login failed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Vedha.Venkataraman\\Documents\\logo.png").build());
		extent.flush();
	}

}
