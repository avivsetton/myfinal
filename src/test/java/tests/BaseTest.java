package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = 	WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
