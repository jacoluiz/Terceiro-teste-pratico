package gluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dao.MassasDAO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import model.Massa;

public class TestRule {
	private static WebDriver driver;
	private static String PATH_DRIVER = "src/test/resources/drivers/chromedriver.exe";
	private static String URL = "https://advantageonlineshopping.com";
	private static Massa massa;

	@Before
	public void initialConfig() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
		carregarMassa();
	}

	@After
	public void finishTest() {
		driver.close();
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Massa getMassa() {
		return massa;
	}

	public static void updateMassa() {
		MassasDAO massas = new MassasDAO();
		massas.update(massa);
		carregarMassa();
	}

	private static void carregarMassa() {
		MassasDAO massas = new MassasDAO();
		for (Massa massa : massas.getMassas()) {
			TestRule.massa = massa;
		}
	}
}
