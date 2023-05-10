package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.HomeElementsMap;

public class HomePage extends HomeElementsMap {

	public void validarPaginaInicial() throws Throwable {
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(loaderAtivo));
		wait.until(ExpectedConditions.invisibilityOf(loaderAtivo));
	}

	public void clicarBotaoSpecialOffer() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoSpecialOffer));
		botaoSpecialOffer.click();
	}

	public void clicarBotaoSeeOffer() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(botaoSeeOffer));
		Thread.sleep(1500);
		botaoSeeOffer.click();
	}

	public void pesquisarProduto() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(botaoAparecerBarraDePesquisa));
		botaoAparecerBarraDePesquisa.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='search']//input")));
		barraDePesquisa.sendKeys(massa.getNameProduct());
	}

	public void clicarResultadoPesquisa() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class = 'top6Products']//a[contains(@class, 'product')]")));
		Thread.sleep(2000);
		resultadoPesquisa.click();
	}
}
