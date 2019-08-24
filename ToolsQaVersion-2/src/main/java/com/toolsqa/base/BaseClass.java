package com.toolsqa.base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.toolsqa.constants.Constants;
import com.toolsqa.logreports.LogReports;
import com.toolsqa.utils.PropertyReader;
import com.toolsqa.utils.ReadLocatorsFile;

public class BaseClass {
	public static WebDriver driver;
	Properties baseClass;
	String url;
	String browser;
	public static LogReports logger=new LogReports();
	

	static PropertyReader propReader = PropertyReader.getInstance();   
	protected static String loc_searchbox = propReader.getValue("loc.searchbox");
	protected static String loc_typeinsearchbox = propReader.getValue("loc.typeinsearchbox");
	protected static String data_pinkDress = propReader.getValue("data.pinkDress");  
	protected static String loc_choosecolor = propReader.getValue("loc.choosecolor");   
	protected static String data_pinkDress_color = propReader.getValue("data.pinkDress_color");    
	protected static String loc_chooseSize = propReader.getValue("loc.chooseSize");   
	protected static String  data_pinkDress_size= propReader.getValue("data.pinkDress_size");
	protected static String loc_product = propReader.getValue("loc.product");

	

	
	
	protected static String loc_enterquantity  = propReader.getValue("loc.enterquantity ");     
	protected static String  data_pinkDress_quantity= propReader.getValue("data.pinkDress_quantity");      
	protected static String loc_addToCartButton  = propReader.getValue("loc.addToCartButton");      
	protected static String loc_shopToolsQaImage  = propReader.getValue("loc.shopToolsQaImage");       
	protected static String loc_product_all  = propReader.getValue("loc.product").replace("xxxx",propReader.getValue("data.blackDress"));
	protected static String  data_blackDress_color= propReader.getValue("data.blackDress_color");      
	protected static String  data_blackDress_size= propReader.getValue("data.blackDress_size");          
	protected static String  loc_cartNameAndTotal = propReader.getValue("loc.cartNameAndTotal");        
	protected static String  loc_productCartList = propReader.getValue("loc.productCartList");

	protected static String  data_Pinkexpected= propReader.getValue("data.Pinkexpected");        
	protected static String  loc_pinkdresscart = propReader.getValue("loc.pinkdresscart");      
	protected static String   loc_blackdresscart = propReader.getValue("loc.blackdresscart");  
	protected static String  data_Blackexpected= propReader.getValue("data.Blackexpected");          
	protected static String   loc_priceofpinkdress = propReader.getValue("loc.priceofpinkdress");   
	protected static String   loc_priceofblackdress = propReader.getValue("loc.priceofblackdress");  
	protected static String   loc_grandTotalFromCart = propReader.getValue("loc.grandTotalFromCart");   
	protected static String   loc_removepinkdress = propReader.getValue("loc.removepinkdress");  
	protected static String   loc_alert = propReader.getValue("loc.alert");  
	protected static String   loc_totalPriceOfProducts = propReader.getValue("loc.totalPriceOfProducts");  
	protected static String  data_afterremovalpinkdress= propReader.getValue("data.afterremovalpinkdress");          


	
	

	
	

			
	
	@BeforeClass
	public void intitailizeBrowser() throws IOException {
		baseClass = ReadLocatorsFile.loadProperty(Constants.CONFIG_FILE);

		url = baseClass.getProperty("URL");
		browser= baseClass.getProperty("chromeBrowser");
		System.out.println("browser is "+browser);

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_FILE);
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_FILE);
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BasicConfigurator.configure();

	}
	/*
	 * public static void main(String[] args) { }
	 */

	

	//@AfterClass
	public void endTest()
	{
		driver.quit();
	}
	public static void main(String[] args) {
		System.out.println(loc_product_all);
	}

}
