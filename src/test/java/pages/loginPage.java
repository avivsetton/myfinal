package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {
	WebDriver driver;
	@FindBy(css = "#user-name")
	private WebElement userfield;
	@FindBy(css = "#password")
	private WebElement passwordfield;
	@FindBy(css = "#login-button")
	private WebElement loginbutton;
	

	public loginPage(WebDriver driver) {
		super(driver);

	}	

	public void login(String user, String password) {
		fillText(userfield, user);
		fillText(passwordfield, password);
		click(loginbutton);
	}
}
