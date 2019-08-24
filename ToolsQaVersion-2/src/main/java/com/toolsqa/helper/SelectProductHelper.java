package com.toolsqa.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.toolsqa.base.BaseClass;
import com.toolsqa.logreports.LogReports;
import com.toolsqa.utils.Utils;

public class SelectProductHelper extends BaseClass{
	public static   Double priceofpink;
	public static 	Double priceofblack;
	public static 	Double grandtotal;
	public static double totalafterdelete;
	public static LogReports logger=new LogReports();
	public static boolean handlePopUp() {
		driver.switchTo().alert().accept();	
		
		return true;
	}
	
	public static void gettingAllProductPrice() {
	String samplepinkprice = driver.findElement(By.xpath(loc_priceofpinkdress)).getText();
	logger.info(samplepinkprice);
	priceofpink =Double.parseDouble(samplepinkprice.substring(1,5));
	logger.info(String.valueOf(priceofpink));

	String sampleblackprice = driver.findElement(By.xpath(loc_priceofblackdress)).getText();
	logger.info(sampleblackprice);
	priceofblack =Double.parseDouble(sampleblackprice.substring(1,5));
	logger.info(String.valueOf(priceofblack));

	String samplegrandtotal = driver.findElement(By.xpath(loc_grandTotalFromCart)).getText();
	logger.info(samplegrandtotal);
	grandtotal =Double.parseDouble(samplegrandtotal.substring(1,5));
	logger.info(String.valueOf(grandtotal));
	}
	
	public static void gettingPriceafterprodRemoval() {
		Utils.ignoreClickInterceptAndClickOnElement(driver,loc_removepinkdress);	
		String sampletotalafterdelete = driver.findElement(By.xpath(loc_totalPriceOfProducts)).getText();
		System.out.println(sampletotalafterdelete);
		 totalafterdelete =Double.parseDouble(sampletotalafterdelete.substring(1,5));
		 logger.info(String.valueOf(totalafterdelete));
		
		
	}
}