package com.toolsqa.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.toolsqa.base.BaseClass;
import com.toolsqa.helper.SelectProductHelper;
import com.toolsqa.utils.JiiraPolicy;
import com.toolsqa.utils.Utils;
import com.toolsqa.validation.ValidateTestResults;

public class OrderProductsAndValidatingCart extends BaseClass {
	@JiiraPolicy(logTicketReady = true)
	@Test(priority=0)
	public void validatewithoutsizeandcolour() {
		Utils.ignoreClickInterceptAndClickOnElement(driver, loc_searchbox);
		Utils.sendKeys(driver,loc_typeinsearchbox,data_pinkDress);
		Utils.ignoreClickInterceptAndClickOnElement(driver, loc_addToCartButton);
		assertTrue(SelectProductHelper.handlePopUp(), "Verified");
		logger.info("popup verfied");
	}
	@JiiraPolicy(logTicketReady = true)
	@Test(priority=1)
	public void searchproducts() {
		Utils.ignoreClickInterceptAndClickOnElement(driver,loc_choosecolor );
		Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, loc_choosecolor,data_pinkDress_color );
		Utils.ignoreClickInterceptAndClickOnElement(driver,loc_chooseSize );
		Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, loc_chooseSize,data_pinkDress_size ); 
		Utils.ignoreClickInterceptAndClickOnElement(driver, loc_addToCartButton);
		logger.info("PINK DROP SHOULDER OVERSIZED T SHIRT - is added to cart");
		Utils.ignoreClickInterceptAndClickOnElement(driver, loc_shopToolsQaImage);
		Utils.ignoreClickInterceptAndClickOnElement(driver, loc_product_all);
		Utils.ignoreClickInterceptAndClickOnElement(driver,loc_choosecolor );
		Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, loc_choosecolor,data_blackDress_color );
		Utils.ignoreClickInterceptAndClickOnElement(driver,loc_chooseSize );
		Utils.ignoreClickInterceptAndClickOnElementforViewPage(driver, loc_chooseSize,data_blackDress_size ); 
		Utils.ignoreClickInterceptAndClickOnElement(driver, loc_addToCartButton);
		logger.info("BLACK LUX GRAPHIC T-SHIRT - BLACK - is added to cart");

	}
	@JiiraPolicy(logTicketReady = true)
	@Test(priority=2)
	public void validateProductsInCart() {
		Utils.ignoreClickInterceptAndClickOnElement(driver, loc_cartNameAndTotal);	
		String pinkDress = driver.findElement(By.xpath(loc_pinkdresscart)).getText();
		String blackDress = driver.findElement(By.xpath(loc_blackdresscart)).getText();
		ValidateTestResults.verifyBoolean(pinkDress, data_Pinkexpected, "The cart and the selected products are equal");
		logger.info("The assertion passed - The product selected and added in the cart are same");
		ValidateTestResults.verifyBoolean(blackDress, data_Blackexpected, "The cart and the selected products are equal");
		logger.info("The assertion passed - The product selected and added in the cart are same");

	}
	@JiiraPolicy(logTicketReady = true)
	@Test(priority=3)
	public void verifyGrandTotal() {

		SelectProductHelper.gettingAllProductPrice();
		assertTrue(Utils.assertGrandtotal(SelectProductHelper.priceofpink, SelectProductHelper.priceofblack, SelectProductHelper.grandtotal), "Verified");
	logger.info("The price verified");
	}
	@JiiraPolicy(logTicketReady = true)
	@Test(priority=4)
	public void removeItemFromCart() {
		SelectProductHelper.gettingPriceafterprodRemoval();
		assertEquals(Utils.assertGrandtotalRemovedProduct(SelectProductHelper.priceofpink, SelectProductHelper.priceofblack, SelectProductHelper.grandtotal), SelectProductHelper.totalafterdelete);
	logger.info("The grand total is equal after removing the cart");
	}
}
