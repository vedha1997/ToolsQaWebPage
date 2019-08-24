package com.toolsqa.logreports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.toolsqa.constants.Constants;

public class LogReports {
Logger logger = null;
	
	public LogReports() {
		getlogger();
		logger = Logger.getLogger(LogReports.class.getName());
	}
	
	public void getlogger() {
		PropertyConfigurator.configure(Constants.LOG4J_FILE);
	}

	public void info(String message){
		logger.info(message);
	}
	
	public void debug(String message){
		
	}
	
	/*
	 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement Element =
	 * driver.findElement(By.linkText(product2FromTheCart));
	 * js.executeScript("arguments[0].scrollIntoView();", Element);
	 */


}
