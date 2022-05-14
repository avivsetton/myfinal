package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	WebDriver driver;
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
	private WebElement addtocart;
	@FindBy(css = "#back-to-products")
	private WebElement backbutton;

	public ProductPage(WebDriver driver) {
		super(driver);

	}

	public void AddtoCart() {
		click(addtocart);
	}

	public void back() {
		click(backbutton);

	}
	
}
