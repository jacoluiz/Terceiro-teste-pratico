package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.CheckoutElementMap;

public class CheckoutPage extends CheckoutElementMap {

	public void aguardarPaginaCarregar() {
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'ORDER PAYMENT')]")));
	}

	public void validarSomaDosProdutos() {
		Double quantidade = Double.parseDouble(quantidadeProdutos.getText().replaceAll("\\D", ""));
		Double valorFinal = Double.parseDouble(valorFinalProdutos.getText().replace("$", "").replace(",", ""));
		
		Assert.assertEquals(valorFinal, quantidade * 449.99, 2);
	}
}
