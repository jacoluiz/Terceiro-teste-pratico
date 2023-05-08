package gluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.*;

public class TestRule {
	private static WebDriver driver;
	private static String PATH_DRIVER = "src/test/resources/drivers/chromedriver.exe";
	private static String URL = "https://advantageonlineshopping.com";

	@Before
	public void initialConfig() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}

	@After
	public void finishTest() {
		driver.close();
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
