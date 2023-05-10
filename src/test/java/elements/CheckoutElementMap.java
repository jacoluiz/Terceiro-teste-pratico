package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutElementMap extends UtilsElements {
	@FindBy(xpath = "//h3[contains(text(), 'ORDER PAYMENT')]")
	protected WebElement tituloPaginaCheckout;

	@FindBy(xpath = "//label[contains(text() , 'TOTAL')]/span")
	protected WebElement valorFinalProdutos;

	@FindBy(xpath = "//div[@id='userCart']//a/label[1]")
	protected WebElement quantidadeProdutos;
}
