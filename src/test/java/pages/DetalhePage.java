package pages;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.DetalheElementsMap;
import gluecode.TestRule;

public class DetalhePage extends DetalheElementsMap {

	public void validarDetalhesProduto(String campo) {
		aguardarPaginaCarregar();

		String dadoDoBanco = null;
		String dadoEmTela = null;

		switch (campo) {
		case "NAME PRODUCT":
			dadoDoBanco = massa.getNameProduct();
			dadoEmTela = nomeProduto.getText();
			break;

		case "CUSTOMIZATION":
			dadoDoBanco = massa.getCustomization();
			break;

		case "DISPLAY":
			dadoDoBanco = massa.getDisplay();
			break;

		case "DISPLAY RESOLUTION":
			dadoDoBanco = massa.getDisplayResolution();
			break;

		case "DISPLAY SIZE":
			dadoDoBanco = massa.getDisplaySize();
			break;

		case "MEMORY":
			dadoDoBanco = massa.getMemory();
			break;

		case "OPERATING SYSTEM":
			dadoDoBanco = massa.getOperatingSystem();
			break;

		case "PROCESSOR":
			dadoDoBanco = massa.getProcessor();
			break;

		case "TOUCHSCREEN":
			dadoDoBanco = massa.getTouchscreen();
			break;

		case "WEIGHT":
			dadoDoBanco = massa.getWeight();
			break;

		case "COLOR":
			dadoDoBanco = massa.getColor();
			dadoEmTela = corSelecionada.getAttribute("title");
			break;

		default:
			System.out.println("Campo informado desconhecido");
			Assert.fail();
			break;

		}
		if (dadoEmTela == null) {
			dadoEmTela = driver.findElement(By.xpath(
					"//label[contains(@class, 'attr')][text()='" + campo + "']/../label[contains(@class, 'value')]"))
					.getText();
		}

		System.out.println("===========\n" + "Massa x Dado em tela -- " + campo + "\n" + dadoDoBanco + "\n" + dadoEmTela
				+ "\n===========");
		Assert.assertEquals(dadoDoBanco, dadoEmTela);

	}

	public void alterarCor() {
		clicarCorDoProduto(massa.getColor());
	}

	public void clicarBotaoAddToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoAddToCart));
		botaoAddToCart.click();
	}

	public void navegarAteCarrinho() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoCart));
		botaoCart.click();
		PageFactory.initElements(driver, this);
	}

	public void alterarCorParaDiferenteDaPresenteNaMassa() {
		String novaCor = sortearCor();
		while (massa.getColor().equals(novaCor)) {
			novaCor = sortearCor();
		}

		clicarCorDoProduto(novaCor);
		salvarNovaCorNoBanco(novaCor);
	}

	public void alterarQuantidade() {
		campoQuantidade.sendKeys(Integer.toString(new Random().nextInt(100)));
	}

	private String sortearCor() {
		String[] coresDisponiveis = new String[] { "BLUE", "BLACK", "GRAY", "PURPLE", "RED", "YELLOW" };
		int rnd = new Random().nextInt(coresDisponiveis.length);
		return coresDisponiveis[rnd];
	}

	private void salvarNovaCorNoBanco(String cor) {
		massa.setColor(cor);
		TestRule.updateMassa();
	}

	private void clicarCorDoProduto(String corParaSelecionar) {
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@ng-show='firstImageToShow']/span[contains(@class, '" + corParaSelecionar + "')]")));
		driver.findElement(
				By.xpath("//div[@ng-show='firstImageToShow']/span[contains(@class, '" + corParaSelecionar + "')]"))
				.click();
	}

	public void aguardarPaginaCarregar() {
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(nomeProduto));
	}

}
