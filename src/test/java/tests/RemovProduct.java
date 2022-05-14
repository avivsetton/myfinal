package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductPage;
import pages.ProductsPage;
import pages.YourCartPage;
import pages.loginPage;



public class RemovProduct extends BaseTest {

	@Test
	public void loginSucceed() {
		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");

	}
	@Test
	public void chooseProduct(){
		
		
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("");
	}
	@Test
	public void addtoCart() {
		
		ProductPage pp = new ProductPage(driver);
		pp.AddtoCart();
		YourCartPage ycp = null;
		int actual = ycp.getNumProduct();
		System.out.println("actual = " + actual);
		int before = 0;
		// should check that we succeed toRemove 1 Product
		Assert.assertEquals(actual, before + 1);
		pp.back();
	}
		
	@Test
	public void removeProduct() {
		YourCartPage ycp = new YourCartPage(driver);
		int before = ycp.getNumProduct();
		ycp.RemoveProduct();
		int actual = ycp.getNumProduct();
		System.out.println("actual = " + actual);
		// should check that we succeed toRemove 1 Product
		Assert.assertEquals(actual, before - 1);
		ycp.Checkout();

	}
}
