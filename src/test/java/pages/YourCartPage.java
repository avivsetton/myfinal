package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage {
	WebDriver driver;
	@FindBy(css = "#checkout")
	private WebElement Checkout;
	@FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
	private WebElement RemoveProduct;

	public YourCartPage(WebDriver driver) {
		super(driver);

	}

	public void Checkout() {
		click(Checkout);
	}
	public void RemoveProduct() {
		click(RemoveProduct);
	}

	
	//validation
	public int getNumProduct() {
		WebElement totalLabel = null;
		String s= getText(totalLabel);
		int num= Integer.parseInt(s);
		return num;
		
	}
}
