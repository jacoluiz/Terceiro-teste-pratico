package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetalheElementsMap extends UtilsElements {
	@FindBy(xpath = "//div[@id='Description']/h1")
	protected WebElement nomeProduto;

	@FindBy(xpath = "//div[@ng-show='firstImageToShow']/span[contains(@class, 'colorSelected')]")
	protected WebElement corSelecionada;

	@FindBy(xpath = "//button[@name='save_to_cart']")
	protected WebElement botaoAddToCart;

	@FindBy(xpath = "//*[@id = 'menuCart']")
	protected WebElement botaoCart;
	
	@FindBy(xpath = "//input[@name='quantity']")
	protected WebElement campoQuantidade;

}
