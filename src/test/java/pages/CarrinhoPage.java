package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.CarrinhoElementsMap;

public class CarrinhoPage extends CarrinhoElementsMap {

	public void esperarPaginaCarregar() {
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(tituloCarrinho));
	}

	public void validarCorDoProduto() {
		Assert.assertTrue(driver.findElement(By.xpath("//span[@title='" + massa.getColor() + "']")).isDisplayed());
	}
	
	public void removerProdutoDoCarrinho() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoRemove));
		botaoRemove.click();
	}
	
	public void validarCarrinhoVazio() {
		Assert.assertTrue(textoCarrinhoVazio.isDisplayed());
	}
	
	public void navegarParaCheckout() {
		botaoCheckout.click();
	}
}
