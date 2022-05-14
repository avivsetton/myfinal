package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
	WebDriver driver;
	@FindBy(css = "#shopping_cart_container")
	private WebElement opencart;
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory") 
	private WebElement addtocart;
	@FindBy(css = "#inventory_item_name")
	private WebElement chooseProduct;

	public ProductsPage(WebDriver driver) {
		super(driver);

	}
	public void orderProduct(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector("div.right_component > span > select"));
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}
			
		}
			
			}
		
	public void chooseProduct(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector("inventory_item_name"));
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}

	public void openCart() {
		click(opencart);

	}
}
