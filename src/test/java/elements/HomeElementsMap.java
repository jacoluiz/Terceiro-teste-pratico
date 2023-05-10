package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeElementsMap extends UtilsElements{
	@FindBy(xpath = "//a[contains(text(), 'SPECIAL OFFER')]")
	protected WebElement botaoSpecialOffer;

	@FindBy(xpath = "//button[@id='see_offer_btn']/..")
	protected WebElement botaoSeeOffer;

	@FindBy(xpath = "//div[@class='loader'][contains(@style, 'display: block;')]")
	protected WebElement loaderAtivo;
	
	@FindBy(xpath = "//a[@title='SEARCH']")
	protected WebElement botaoAparecerBarraDePesquisa;

	@FindBy(xpath = "//div[@id='search']//input")
	protected WebElement barraDePesquisa;
	
	@FindBy(xpath = "//div[@class = 'top6Products']//a[contains(@class, 'product')]//p[text() = 'HP PAVILION 15Z TOUCH LAPTOP']")
	protected WebElement resultadoPesquisa;
}
