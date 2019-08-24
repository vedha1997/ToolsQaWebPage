package com.toolsqa.validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.toolsqa.logreports.LogReports;

public class ValidateTestResults {
	static LogReports logs = new LogReports();
	//static WebDriver driver;
	static LogReports report = new LogReports();
	
	public static boolean verifyBoolean(Object actual, Object expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
			report.info("Passed : " + message + ": " + "Actual data : " + actual + " " + "Expected :" + expected);
			return true;
		} catch (AssertionError assertionError) {
			return false;
		}
	}
	public static void isDisplayed(String xpath,String Validationmessage,String message,WebDriver driver) {
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(), Validationmessage);
		logs.info(message);

	}

}
