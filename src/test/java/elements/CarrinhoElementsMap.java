package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarrinhoElementsMap extends UtilsElements {

	@FindBy(xpath = "//h3[contains(text(), 'SHOPPING CART')]")
	protected WebElement tituloCarrinho;

	@FindBy(xpath = "//a[contains(text(), 'REMOVE')]")
	protected WebElement botaoRemove;

	@FindBy(xpath = "//div[@class='bigEmptyCart center']/label[text() ='Your shopping cart is empty']")
	protected WebElement textoCarrinhoVazio;
	
	@FindBy(xpath = "//button[@id = 'checkOutButton']")
	protected WebElement botaoCheckout;
}
