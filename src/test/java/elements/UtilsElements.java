package elements;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gluecode.TestRule;
import model.Massa;

public class UtilsElements {
	protected Massa massa = TestRule.getMassa();
	protected WebDriver driver = TestRule.getDriver();
	protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	protected Actions actions = new Actions(driver);

	protected void aguardarScroll() {
		wait.until(webDriver -> {
			long scrollInicial = (long) ((JavascriptExecutor) webDriver).executeScript("return window.pageYOffset;");
			try {
				// Espera um intervalo de tempo para permitir que o scroll aconteça
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long scrollFinal = (long) ((JavascriptExecutor) webDriver).executeScript("return window.pageYOffset;");
			return scrollInicial == scrollFinal;
		});
	}
}
