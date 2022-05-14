package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductPage;
import pages.ProductsPage;
import pages.YourCartPage;
import pages.loginPage;



public class BuyProducts extends BaseTest {

	

	@Test
	public void LoginSucceed() {
		loginPage lp = new loginPage(driver);
		lp.login("standard_user", "secret_sauce");

	}

	@Test
	public void orderProduct(){
		
		ProductsPage orp = new ProductsPage(driver);
		orp.orderProduct("");
	}
		
	@Test
	public void chooseProduct(){
		
		
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("");
	}
	@Test
	public void AddtoCart() {
		
		ProductPage pp = new ProductPage(driver);
		pp.AddtoCart();
		pp.back();
	}

	@Test
	public void openCart() {
		ProductsPage psp = new ProductsPage(driver);
		psp.openCart();

		YourCartPage ycp = new YourCartPage(driver);
		int before = ycp.getNumProduct();
		int actual = ycp.getNumProduct();
		System.out.println("actual = " + actual);
		// should check that we succeed toRemove 1 Product
		Assert.assertEquals(actual, before + 1);
		ycp.Checkout();

	}

}
