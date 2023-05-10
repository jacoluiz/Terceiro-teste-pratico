package elements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import gluecode.TestRule;
import model.Massa;

public class UtilsElements {
	protected Massa massa = TestRule.getMassa();
	protected WebDriver driver = TestRule.getDriver();
	protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
